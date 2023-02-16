package com.magellans.cardtrading.service;

import com.magellans.cardtrading.generic.service.GenericService;
import com.magellans.cardtrading.persistence.entity.Account;
import com.magellans.cardtrading.persistence.entity.AccountEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface AccountService extends GenericService<Account, Integer> {

    @Transactional
    Boolean checkAccount(AccountEntity accountEntity) throws  Exception;
    @Transactional
    Boolean checkAccountByNick(AccountEntity accountEntity) throws  Exception;

    @Transactional
    Boolean createAccount(AccountEntity accountEntity) throws  Exception;

    @Transactional
    Boolean signIn(AccountEntity accountEntity) throws  Exception;

    @Transactional
    String getPassword(AccountEntity accountEntity) throws  Exception;
}
