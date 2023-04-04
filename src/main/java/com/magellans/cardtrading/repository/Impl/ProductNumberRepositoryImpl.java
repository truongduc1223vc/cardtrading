package com.magellans.cardtrading.repository.Impl;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.jpa.Condition;
import com.magellans.cardtrading.generic.jpa.DataPage;
import com.magellans.cardtrading.generic.jpa.GenericRepositoryCustom;
import com.magellans.cardtrading.repository.ProductNumberRepository;
import com.magellans.cardtrading.resource.model.*;
import com.magellans.cardtrading.utils.ConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.SingularAttribute;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Repository("ProductNumberRepository")
@Slf4j
public class ProductNumberRepositoryImpl extends GenericRepositoryCustom implements ProductNumberRepository {
//    private static Logger logger = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public FrontEndRS<Product> getListProductCode() throws Exception{
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();

            sqlSelect.append(" select pn.id as ID, pn.ProductId as ProductId, pn.ProductName as ProductName from productnumber pn;");
//            sqlSelect.append(" from ProductNumber pn");
//            sqlSelect.append(" order by rd.id desc");
            List<Product> rs = new ArrayList<>();
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), Product.class);
            query = setParametersByMap(query, mapParams);
            rs = query.getResultList();
            Integer total = 32;
            Integer totalPage = 0;
//			Integer totalPage = (total.intValue() % pageSize) == 0 ? total.intValue() / pageSize : total.intValue() / pageSize + 1;;
            return new FrontEndRS(rs);
        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }
    @Override
    public void updateDeal(String date) throws Exception {
        try {
            HashMap<String, Object> params = new HashMap<>();
            StringBuilder sql = new StringBuilder();
            sql.append(" update orderdetail set AccectOrder = :unaccectOrder where CAST(DateCreated as DATE) = :date and AccectOrder = :accectOrder");
            params.put("accectOrder", CardConfig.accectOrder);
            params.put("unaccectOrder", CardConfig.unAccectOrder);
            params.put("date", date);
            Query query = entityManager.createNativeQuery(sql.toString(), OrderDetail.class);
            query = setParametersByMap(query, params);
            query.executeUpdate();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }
    @Override
    public FrontEndRS<OrderDetail> selectByAccountAndDateAndLinkId(String deviceId, LocalDate date, String idProduct, String appId) throws Exception {
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();

            sqlSelect.append(" select id, ProductId as ProductId, AppId as AppId, BuyDate as BuyDate, DeviceId as DeviceId, AccectOrder as AccectOrder");
            sqlSelect.append(" from orderdetail where ProductId = :productId and AppId= :appId and CAST(BuyDate as DATE) = :date and AccectOrder = :accectOrder and DeviceId = :deviceId" );
            mapParams.put("productId", idProduct);
            mapParams.put("appId", appId);
            mapParams.put("date", date);
            mapParams.put("deviceId", deviceId);
            mapParams.put("accectOrder", 1);
            List<OrderDetail> rs = new ArrayList<>();
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), OrderDetail.class);
            query = setParametersByMap(query, mapParams);
            rs = query.getResultList();
            return new FrontEndRS(rs);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public void createDeal(String deviceId, String idProduct, String appId) throws  Exception{
        try {
            ZoneId vietnam = ZoneId.of("Asia/Ho_Chi_Minh");
            LocalDateTime fullVietNam = LocalDateTime.now(vietnam);
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();
            sqlSelect.append(" insert into orderdetail( ProductId, AppId, BuyDate, DeviceId, AccectOrder)");
            sqlSelect.append(" values (:idProduct, :appId, :buyDate, :deviceId, :accectOrder);");
            mapParams.put("idProduct", idProduct);
            mapParams.put("appId", appId);
            mapParams.put("buyDate", fullVietNam);
            mapParams.put("deviceId", deviceId);
            mapParams.put("accectOrder", 1);
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), OrderDetail.class);
            query = setParametersByMap(query, mapParams);
            query.executeUpdate();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public FrontEndRS<Product> getListProduct(String region, String appId) throws Exception{
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();

            sqlSelect.append(" select pn.id as ID, pn.ProductId as ProductId, pn.ProductName as ProductName," +
                    "pn.Price as Price, pn.Content as Content from productnumber pn");
            if (!StringUtils.isEmpty(appId)) {
                sqlSelect.append(" where pn.AppId = :appId ");
                mapParams.put("appId", appId);
            }
            if (!StringUtils.isEmpty(region)) {
                sqlSelect.append(" and pn.region = :region");
                mapParams.put("region", region);
            }
            List<Product> rs = new ArrayList<>();
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), Product.class);
            query = setParametersByMap(query, mapParams);
            rs = query.getResultList();
            Integer total = 32;
            Integer totalPage = 0;
//			Integer totalPage = (total.intValue() % pageSize) == 0 ? total.intValue() / pageSize : total.intValue() / pageSize + 1;;
            return new FrontEndRS(rs);
        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }
    @Override
    public List<OrderDetail> dealOfYesterday()throws Exception{
        try{
            LocalDate today = LocalDate.now();
            String date = today.toString();
            List<OrderDetail> dealNumbers = new ArrayList<>();
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();

            sqlSelect.append(" select id, ProductId as ProductId, AppId as AppId, BuyDate as BuyDate, DeviceId as DeviceId, AccectOrder as AccectOrder");
            sqlSelect.append(" from orderdetail where CAST(BuyDate as DATE) = :date and AccectOrder= :accectOrder" );
            mapParams.put("date", date);
            mapParams.put("accectOrder", CardConfig.accectOrder);
//			List<ProductCode> rs = new ArrayList<>();
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), OrderDetail.class);
            query = setParametersByMap(query, mapParams);
            dealNumbers = query.getResultList();
            return dealNumbers;
        }
        catch (Exception ex){
            log.error(ex.getMessage(), ex);
            throw ex;
        }

    }
    @Override
    public FrontEndRS<ProductDetail> getProductDetail(String idProduct) throws Exception{
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();

            sqlSelect.append(" select pd.id as ID, pd.ProductId as ProductId, pd.Content as Content," +
                    "pd.DateProduct as DateProduct, pd.Result as Result from productdetail pd");
            if (!StringUtils.isEmpty(idProduct)) {
                sqlSelect.append(" where pd.ProductId = :idProduct ");
                mapParams.put("idProduct", idProduct);
            }
            List<ProductDetail> rs = new ArrayList<>();
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), ProductDetail.class);
            query = setParametersByMap(query, mapParams);
            rs = query.getResultList();
            Integer total = 32;
            Integer totalPage = 0;
//			Integer totalPage = (total.intValue() % pageSize) == 0 ? total.intValue() / pageSize : total.intValue() / pageSize + 1;;
            return new FrontEndRS(rs);
        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public EntityTransaction getTransaction() {
        return null;
    }

    @Override
    public SingularAttribute getIdAttribute() {
        return null;
    }

    @Override
    public List<ProductNumber> findByAttributeContainsText(String attributeName, String text) {
        return null;
    }

    @Override
    public List<ProductNumber> findByAttributeName(String attributeName, Object value) {
        return null;
    }

    @Override
    public List<ProductNumber> findByAttributeName(String attributeName, Object[] values) {
        return null;
    }

    @Override
    public List<ProductNumber> findByIds(List<Integer> integers) {
        return null;
    }

    @Override
    public Long countById(Integer integer) {
        return null;
    }

    @Override
    public Long countByCondition(String attributeName, Object value) {
        return null;
    }

    @Override
    public Long countByCondition(Condition cond) {
        return null;
    }

    @Override
    public Long countByCondition(Map<String, Object> mapPropertyWhere) {
        return null;
    }

    @Override
    public Long countByCondition(List<Condition.CondItem> condItems) {
        return null;
    }

    @Override
    public DataPage<ProductNumber> findByCondition(Condition cond) {
        return null;
    }

    @Override
    public List<ProductNumber> findByCondition(List<Condition.CondItem> condItems) {
        return null;
    }

    @Override
    public void updateByProperty(Integer integer, String propertyName, Object value) {

    }

    @Override
    public void updateByProperty(Integer integer, Map<String, Object> mapPropertyUpdate) {

    }

    @Override
    public void updateByProperty(Map<String, Object> mapPropertyUpdate, Map<String, Object> mapPropertyWhere) {

    }

    @Override
    public void updateByProperty(List<Condition.CondItem> lstUpdate, List<Condition.CondItem> lstWhere) {

    }

    @Override
    public Optional<ProductNumber> findOneByProperty(Map<String, Object> mapPropertyWhere) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductNumber> findOneByProperty(List<Condition.CondItem> condItems) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductNumber> findOneByProperty(String propertyName, Object value) {
        return Optional.empty();
    }

    @Override
    public void deleteByCondition(List<Condition.CondItem> condItems) {

    }

    @Override
    public List<ProductNumber> findAll() {
        return null;
    }

    @Override
    public List<ProductNumber> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductNumber> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductNumber> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(ProductNumber productNumber) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductNumber> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ProductNumber> S save(S s) {
        return null;
    }

    @Override
    public <S extends ProductNumber> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ProductNumber> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ProductNumber> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends ProductNumber> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ProductNumber> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProductNumber getOne(Integer integer) {
        return null;
    }

    @Override
    public ProductNumber getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends ProductNumber> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductNumber> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductNumber> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProductNumber> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductNumber> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductNumber> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Optional<ProductNumber> findOne(Specification<ProductNumber> specification) {
        return Optional.empty();
    }

    @Override
    public List<ProductNumber> findAll(Specification<ProductNumber> specification) {
        return null;
    }

    @Override
    public Page<ProductNumber> findAll(Specification<ProductNumber> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<ProductNumber> findAll(Specification<ProductNumber> specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<ProductNumber> specification) {
        return 0;
    }
}
