package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.resource.model.Card;
import com.magellans.cardtrading.resource.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Boolean existsByNumbercode(String numbercode);
    Boolean existsByNumberserial(String numberserinal);
}
