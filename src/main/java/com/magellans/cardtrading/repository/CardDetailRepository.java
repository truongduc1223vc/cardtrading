package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.resource.model.CardDetail;
import com.magellans.cardtrading.resource.model.CardInfor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardDetailRepository extends JpaRepository<CardDetail, Long> {
    List<CardDetail> findAllByIdnetworkAndAppid(String idnetwork, String appid);
}
