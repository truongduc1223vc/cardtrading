package com.magellans.cardtrading.repository.Impl;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.jpa.Condition;
import com.magellans.cardtrading.generic.jpa.DataPage;
import com.magellans.cardtrading.generic.jpa.GenericRepositoryCustom;
import com.magellans.cardtrading.repository.ProductNumberRepository;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.metamodel.SingularAttribute;
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
