package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.entity.ProductNumber;
import com.magellans.cardtrading.generic.jpa.GenericRepository;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.resource.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductNumberRepository extends GenericRepository<ProductNumber, Integer>, JpaRepository<ProductNumber, Integer> {

    FrontEndRS<Product> getListProductCode() throws Exception;
}
