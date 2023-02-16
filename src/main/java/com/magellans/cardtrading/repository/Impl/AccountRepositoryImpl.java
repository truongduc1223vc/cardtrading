package com.magellans.cardtrading.repository.Impl;

import com.magellans.cardtrading.generic.jpa.Condition;
import com.magellans.cardtrading.generic.jpa.DataPage;
import com.magellans.cardtrading.generic.jpa.GenericRepositoryCustom;
import com.magellans.cardtrading.persistence.entity.Account;
import com.magellans.cardtrading.persistence.entity.AccountEntity;
import com.magellans.cardtrading.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.math.BigInteger;
import java.util.*;

@Repository("AccountRepository")
@Slf4j
public class AccountRepositoryImpl extends GenericRepositoryCustom implements AccountRepository {
    private static Logger logger = LoggerFactory.getLogger(AccountRepositoryImpl.class);

    @PersistenceContext
    protected EntityManager entityManager;



    @Override
    public Integer countAccountByEmailPhone(AccountEntity accountEntity) throws Exception{
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();
            sqlSelect.append(" select count(*)");
            sqlSelect.append(" from account");
            sqlSelect.append(" where appId = :appId and (PhoneNumber = :phoneNumber or Email = :email)");
            mapParams.put("appId", accountEntity.getAppId());
            mapParams.put("phoneNumber", accountEntity.getPhoneNumber());
            mapParams.put("email", accountEntity.getEmail());
            Integer rs = null;
            Query query = entityManager.createNativeQuery(sqlSelect.toString());
            query = setParametersByMap(query, mapParams);
            rs = ((BigInteger) query.getSingleResult()).intValue();

            return rs;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public void createAccount(AccountEntity accountEntity) throws  Exception{
        try {
//            String appId, String idToken, String status, Integer coin
//            AccountEntity accountEntity = new AccountEntity();
//            accountEntity.getAppId();
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();
            sqlSelect.append(" insert into account( Name, NickName, PhoneNumber, Email, Password, AppId, Total)");
            sqlSelect.append(" values (:name, :nickName, :phoneNumber, :email, :password, :appId, :total);");
            mapParams.put("name", accountEntity.getName());
            mapParams.put("nickName", accountEntity.getNickName());
            mapParams.put("phoneNumber", accountEntity.getPhoneNumber());
            mapParams.put("email", accountEntity.getEmail());
            mapParams.put("password", accountEntity.getPassword());
            mapParams.put("appId", accountEntity.getAppId());
            mapParams.put("total", accountEntity.getTotal());
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), Account.class);
            query = setParametersByMap(query, mapParams);
            query.executeUpdate();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }


    @Override
    public void signIn(AccountEntity accountEntity) throws  Exception{
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();
            sqlSelect.append(" insert into account( Name, NickName, PhoneNumber, Email, Password, AppId, Total)");
            sqlSelect.append(" values (:name, :nickName, :phoneNumber, :email, :password, :appId, :total);");
            mapParams.put("name", accountEntity.getName());
            mapParams.put("nickName", accountEntity.getNickName());
            mapParams.put("phoneNumber", accountEntity.getPhoneNumber());
            mapParams.put("email", accountEntity.getEmail());
            mapParams.put("password", accountEntity.getPassword());
            mapParams.put("appId", accountEntity.getAppId());
            mapParams.put("total", accountEntity.getTotal());
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), Account.class);
            query = setParametersByMap(query, mapParams);
            query.executeUpdate();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public Account getAccountWithNickAndAppId(String nickName, String appId) throws Exception{
        try {
            HashMap<String, Object> mapParams = new HashMap<>();
            StringBuilder sqlSelect = new StringBuilder();
            sqlSelect.append(" select *");
            sqlSelect.append(" from account");
            sqlSelect.append(" where appId = :appId and nickName = :nickName");
            mapParams.put("appId", appId);
            mapParams.put("nickName", nickName);
            List<Account> rs = new ArrayList<>();
            Query query = entityManager.createNativeQuery(sqlSelect.toString(), Account.class);
            query = setParametersByMap(query, mapParams);
            rs = query.getResultList();

            return rs.get(0);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
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
    public List<Account> findByAttributeContainsText(String attributeName, String text) {
        return null;
    }

    @Override
    public List<Account> findByAttributeName(String attributeName, Object value) {
        return null;
    }

    @Override
    public List<Account> findByAttributeName(String attributeName, Object[] values) {
        return null;
    }

    @Override
    public List<Account> findByIds(List<Integer> integers) {
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
    public DataPage<Account> findByCondition(Condition cond) {
        return null;
    }

    @Override
    public List<Account> findByCondition(List<Condition.CondItem> condItems) {
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
    public Optional<Account> findOneByProperty(Map<String, Object> mapPropertyWhere) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findOneByProperty(List<Condition.CondItem> condItems) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findOneByProperty(String propertyName, Object value) {
        return Optional.empty();
    }

    @Override
    public void deleteByCondition(List<Condition.CondItem> condItems) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Account> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Account account) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Account> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Account> S save(S s) {
        return null;
    }

    @Override
    public <S extends Account> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Account> findById(Integer integer) {
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
    public <S extends Account> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Account> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Account> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Account getOne(Integer integer) {
        return null;
    }

    @Override
    public Account getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Account> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Account> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Account> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Optional<Account> findOne(Specification<Account> specification) {
        return Optional.empty();
    }

    @Override
    public List<Account> findAll(Specification<Account> specification) {
        return null;
    }

    @Override
    public Page<Account> findAll(Specification<Account> specification, Pageable pageable) {
        return null;
    }

    @Override
    public List<Account> findAll(Specification<Account> specification, Sort sort) {
        return null;
    }

    @Override
    public long count(Specification<Account> specification) {
        return 0;
    }
}
