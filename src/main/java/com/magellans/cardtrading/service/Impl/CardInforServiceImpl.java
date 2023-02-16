package com.magellans.cardtrading.service.Impl;

import com.magellans.cardtrading.generic.service.GenericServiceImpl;
import com.magellans.cardtrading.persistence.entity.CardInforEntity;
import com.magellans.cardtrading.repository.CardDetailRepository;
import com.magellans.cardtrading.repository.CardInforRepository;
import com.magellans.cardtrading.resource.model.CardInfor;
import com.magellans.cardtrading.resource.model.FrontEndRS;
import com.magellans.cardtrading.service.CardInforService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CardInforServiceImpl extends GenericServiceImpl<CardInfor, Integer> implements CardInforService {
    @Autowired
    private CardInforRepository cardInforRepository;

    @Autowired
    private CardDetailRepository cardDetailRepository;

    @Override
    public FrontEndRS<CardInforEntity> getProduct(String appId, Boolean status) throws Exception {

        List<CardInfor> cardInforList = cardInforRepository.findAllByAppidAndStatus(appId, status);
        List<CardInforEntity> lstRsPro = new ArrayList<>();
        for (CardInfor item : cardInforList
             ) {
            CardInforEntity cardInforEntity = new CardInforEntity();
            BeanUtils.copyProperties(item, cardInforEntity);
            cardInforEntity.setCardDetailList(cardDetailRepository.findAllByIdnetworkAndAppid(item.getidnetwork(), item.getAppid()));
            lstRsPro.add(cardInforEntity);
        }

        return new FrontEndRS(lstRsPro);
    }

    @Override
    public CardInfor create(CardInfor cardInfor) throws Exception {
        return null;
    }

    @Override
    public void update(Map<String, Object> params) throws Exception {

    }
}
