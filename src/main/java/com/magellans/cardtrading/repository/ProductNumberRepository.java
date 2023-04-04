package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.jpa.GenericRepository;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.OrderDetail;
import com.magellans.cardtrading.resource.model.Product;
import com.magellans.cardtrading.resource.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductNumberRepository extends GenericRepository<ProductNumber, Integer>, JpaRepository<ProductNumber, Integer> {

    FrontEndRS<Product> getListProductCode() throws Exception;

    FrontEndRS<Product> getListProduct(String region, String appId) throws Exception;

    void createDeal(String deviceId, String idProduct, String appId) throws  Exception;

    FrontEndRS<OrderDetail> selectByAccountAndDateAndLinkId(String deviceId, LocalDate date, String idProduct, String appId) throws Exception;

    void updateDeal(String date) throws  Exception;
    FrontEndRS<ProductDetail> getProductDetail(String idProduct) throws Exception;

    List<OrderDetail> dealOfYesterday() throws Exception;
}
