package com.magellans.cardtrading.generic.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.EntityTransaction;
import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, PagingAndSortingRepository<T, ID>, JpaSpecificationExecutor<T> {
    EntityTransaction getTransaction();

    SingularAttribute getIdAttribute();

    List<T> findByAttributeContainsText(String attributeName, String text);

    List<T> findByAttributeName(String attributeName, Object value);

    List<T> findByAttributeName(String attributeName, Object[] values);

    List<T> findByIds(List<ID> ids);

    Long countById(ID id);

    Long countByCondition(String attributeName, Object value);

    Long countByCondition(Condition cond);

    Long countByCondition(Map<String, Object> mapPropertyWhere);

    Long countByCondition(List<Condition.CondItem> condItems);

    DataPage<T> findByCondition(Condition cond);

    List<T> findByCondition(List<Condition.CondItem> condItems);

    void updateByProperty(ID id, String propertyName, Object value);

    void updateByProperty(ID id, Map<String, Object> mapPropertyUpdate);

    void updateByProperty(Map<String, Object> mapPropertyUpdate, Map<String, Object> mapPropertyWhere);

    void updateByProperty(List<Condition.CondItem> lstUpdate, List<Condition.CondItem> lstWhere);

    Optional<T> findOneByProperty(Map<String, Object> mapPropertyWhere);

    Optional<T> findOneByProperty(List<Condition.CondItem> condItems);

    Optional<T> findOneByProperty(String propertyName, Object value);

    void deleteByCondition(List<Condition.CondItem> condItems);
}
