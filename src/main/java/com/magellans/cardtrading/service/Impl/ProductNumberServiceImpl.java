package com.magellans.cardtrading.service.Impl;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.service.GenericServiceImpl;
import com.magellans.cardtrading.repository.ProductNumberRepository;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.Product;
import com.magellans.cardtrading.service.ProductNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductNumberServiceImpl extends GenericServiceImpl<ProductNumber, Integer> implements ProductNumberService {

    @Autowired
    private ProductNumberRepository productNumberRepository;
    @Override
    public FrontEndRS<Product> getListProductCode() throws Exception{
        return productNumberRepository.getListProductCode();
    }


    @Override
    public ProductNumber create(ProductNumber productNumber) throws Exception {
        return null;
    }

    @Override
    public void update(Map<String, Object> params) throws Exception {

    }
}