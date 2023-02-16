package com.magellans.cardtrading.service;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.service.GenericService;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface ProductNumberService extends GenericService<ProductNumber, Integer> {
    @Transactional
    FrontEndRS<Product> getListProductCode() throws Exception;

    @Transactional
    FrontEndRS<Product> getListProduct(String region, String appId) throws Exception;
}
