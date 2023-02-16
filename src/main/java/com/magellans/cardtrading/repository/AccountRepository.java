package com.magellans.cardtrading.repository;

import com.magellans.cardtrading.generic.jpa.GenericRepository;
import com.magellans.cardtrading.persistence.entity.Account;
import com.magellans.cardtrading.persistence.entity.AccountEntity;

public interface AccountRepository extends GenericRepository<Account, Integer> {
    Integer countAccountByEmailPhone(AccountEntity accountEntity) throws Exception;

    void createAccount(AccountEntity accountEntity) throws Exception;

    void signIn(AccountEntity accountEntity) throws Exception;

    Account getAccountWithNickAndAppId(String nickName, String appId) throws Exception;
}
