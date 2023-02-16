package com.magellans.cardtrading.controller;

import com.magellans.cardtrading.generic.service.Response;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.service.ProductNumberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final String PARAM_AUTHORIZATION = "Authorization";
    @Autowired
    private ProductNumberService productNumberService;

    //Get history
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseEntity getInforCard() {
        try {

            FrontEndRS frontEndRS = productNumberService.getListProductCode();
            return ResponseEntity.ok(frontEndRS);
        } catch (Exception e) {
            return Response.exception(e);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getListProduct(@RequestParam(name = "region", required = true) String region
            , @RequestHeader(PARAM_AUTHORIZATION) String token
            , @RequestParam(name = "appId", required = false) String appId) {
        try {
            if (StringUtils.isNotBlank(token)) {
                FrontEndRS frontEndRS = new FrontEndRS();
                if (region.equals("0")) {
//                    frontEndRS = productServiceV3.getProduct(null, pageNumber, pageSize, appId);

                     frontEndRS = productNumberService.getListProduct(null, appId);
                }else {
//                    frontEndRS = productServiceV3.getProduct(region, pageNumber, pageSize, appId);
                    frontEndRS = productNumberService.getListProduct(region, appId);
                }
                return ResponseEntity.ok(frontEndRS);
            }
            else {
                return ResponseEntity.status(400).body("You don't have permission");
            }
//            FrontEndRS frontEndRS = productNumberService.getListProductCode();
//            return ResponseEntity.ok(frontEndRS);
        } catch (Exception e) {
            return Response.exception(e);
        }
    }
}