package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.resource.model.CardInfor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardInforRepository extends JpaRepository<CardInfor, Long> {
    List<CardInfor> findAllByAppidAndStatus(String appid, Boolean status);
}
