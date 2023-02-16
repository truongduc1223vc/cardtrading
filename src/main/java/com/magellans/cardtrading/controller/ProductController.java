package com.magellans.cardtrading.controller;

import com.magellans.cardtrading.generic.service.Response;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.service.ProductNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductNumberService productNumberService;
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity getInforCard() {
        try {

            FrontEndRS frontEndRS = productNumberService.getListProductCode();
            return ResponseEntity.ok(frontEndRS);
        } catch (Exception e) {
            return Response.exception(e);
        }
    }
}