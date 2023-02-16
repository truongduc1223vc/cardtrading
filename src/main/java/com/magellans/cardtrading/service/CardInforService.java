package com.magellans.cardtrading.service;

import com.magellans.cardtrading.generic.service.GenericService;
import com.magellans.cardtrading.persistence.entity.Account;
import com.magellans.cardtrading.persistence.entity.CardInforEntity;
import com.magellans.cardtrading.resource.model.CardInfor;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface CardInforService extends GenericService<CardInfor, Integer> {

    @Transactional
    FrontEndRS<CardInforEntity> getProduct(String appId, Boolean status) throws Exception;
}
