package com.magellans.cardtrading.service;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.service.GenericService;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.OrderDetail;
import com.magellans.cardtrading.resource.model.Product;
import com.magellans.cardtrading.resource.model.ProductDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ProductNumberService extends GenericService<ProductNumber, Integer> {
    @Transactional
    FrontEndRS<Product> getListProductCode() throws Exception;

    @Transactional
    FrontEndRS<ProductDetail> getProductDetail(String idProduct) throws Exception;
    @Transactional
    Boolean createDeal(String deviceId, String idProduct, String appId) throws  Exception;

    @Transactional
    Boolean countDeal(String deviceId, LocalDate date, String idProduct, String appId) throws Exception;
    @Transactional
    Boolean updateDeal(String today) throws Exception;
    @Transactional
    FrontEndRS<Product> getListProduct(String region, String appId) throws Exception;

    @Transactional
    List<OrderDetail> dealOfYesterday() throws Exception;
}
