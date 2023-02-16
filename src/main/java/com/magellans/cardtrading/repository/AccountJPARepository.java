package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.persistence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJPARepository extends JpaRepository<Account, Long > {
    Integer countAllByAppIdAndNickName(String appId, String nick);

//    Integer countAllByAppIdAndNickName
}
