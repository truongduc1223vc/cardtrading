package com.magellans.cardtrading.generic.service;

import com.magellans.cardtrading.generic.jpa.GenericRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

    private GenericRepository<T, PK> genericRepository;

    public GenericServiceImpl() {
    }

    public GenericServiceImpl(GenericRepository<T, PK> genericRepository) {
        this.genericRepository = genericRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(PK pk) throws Exception {
        return genericRepository.findById(pk);
    }
    
    @Override
    public void update(T t) throws Exception {
        genericRepository.save(t);
    }

    protected void setGenericRepository(GenericRepository<T, PK> genericRepository) {
        this.genericRepository = genericRepository;
    }
}