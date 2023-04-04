package com.magellans.cardtrading.service.Impl;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.service.GenericServiceImpl;
import com.magellans.cardtrading.repository.ProductNumberRepository;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.OrderDetail;
import com.magellans.cardtrading.resource.model.Product;
import com.magellans.cardtrading.resource.model.ProductDetail;
import com.magellans.cardtrading.service.ProductNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
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
    public FrontEndRS<ProductDetail> getProductDetail(String idProduct) throws Exception{
        return productNumberRepository.getProductDetail(idProduct);
    }

    public Boolean createDeal(String deviceId, String idProduct, String appId) throws  Exception{
        productNumberRepository.createDeal(deviceId, idProduct, appId );
        return true;
    }

    public Boolean countDeal(String deviceId, LocalDate date, String idProduct, String appId) throws Exception{
        FrontEndRS<OrderDetail> totalDeal = productNumberRepository.selectByAccountAndDateAndLinkId( deviceId, date, idProduct, appId);

        return (totalDeal.getItems().size() == 0);
    }
    @Override
    public Boolean updateDeal(String date) throws Exception {
        productNumberRepository.updateDeal(date);
        return null;
    }
    @Override
    public FrontEndRS<Product> getListProduct(String region, String appId) throws Exception{
        return productNumberRepository.getListProduct(region, appId);
    }
    @Transactional
    public List<OrderDetail> dealOfYesterday() throws Exception{
        List<OrderDetail> dealNumbersList = productNumberRepository.dealOfYesterday();
        return dealNumbersList;
    }

    @Override
    public ProductNumber create(ProductNumber productNumber) throws Exception {
        return null;
    }

    @Override
    public void update(Map<String, Object> params) throws Exception {

    }
}