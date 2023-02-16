package com.magellans.cardtrading.generic.jpa;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;

public abstract class GenericRepositoryCustom {

    @PersistenceContext
    protected EntityManager entityManager;

    public HashMap<String, Object> newMapParameters() {
        return new HashMap<>();
    }

    public String createParameter(String condition, String sql, HashMap<String, Object> mapParams, String key,
                                  Object value) {
        if (value != null) {
            sql += condition;
            mapParams.put(key, value);
        }
        return sql;
    }

    public Pageable pageable(Condition cond) {
        return PageRequest.of(cond.getFirstItemIndex(), cond.getMaxItems());
    }

    public Query pagingQuery(Query query, Integer firstItem, Integer maxItem) {
        if (firstItem != null && maxItem != null && maxItem > 0 && firstItem >= 0) {
            query.setMaxResults(maxItem);
            query.setFirstResult(firstItem);
        }
        return query;
    }

    public Query setParametersByMap(Query query, HashMap<String, Object> mapParams) {
        mapParams.keySet().forEach(param -> {
            Object value = mapParams.get(param);
            query.setParameter(param, value);
        });
        return query;
    }

}
