package com.magellans.cardtrading.generic.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

public interface GenericService<T, PK> {
    T create(T t) throws Exception;
    Optional<T> findById(PK pk) throws Exception;

    @Transactional
    void update(T t) throws Exception;

    @Transactional
    void update(Map<String, Object> params) throws Exception;
}
