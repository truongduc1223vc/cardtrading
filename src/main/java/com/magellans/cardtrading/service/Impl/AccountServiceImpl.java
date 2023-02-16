package com.magellans.cardtrading.service.Impl;

import com.magellans.cardtrading.generic.service.GenericServiceImpl;
import com.magellans.cardtrading.persistence.entity.Account;
import com.magellans.cardtrading.persistence.entity.AccountEntity;
import com.magellans.cardtrading.repository.AccountJPARepository;
import com.magellans.cardtrading.repository.AccountRepository;
import com.magellans.cardtrading.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AccountServiceImpl extends GenericServiceImpl<Account, Integer> implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountJPARepository accountJPARepository;


    @Override
    public Boolean checkAccount(AccountEntity accountEntity) throws Exception {
        Integer countAccount = accountRepository.countAccountByEmailPhone(accountEntity);
        return (countAccount == 0);
    }

    @Override
    public Boolean checkAccountByNick(AccountEntity accountEntity) throws Exception {
        Integer countAccountNick = accountJPARepository.countAllByAppIdAndNickName(accountEntity.getAppId(), accountEntity.getNickName());
        return (countAccountNick == 0);
    }

    @Override
    public Boolean createAccount(AccountEntity accountEntity) throws Exception {
        accountRepository.createAccount(accountEntity);
        return true;
    }

    @Override
    public Boolean signIn(AccountEntity accountEntity) throws Exception {
        accountRepository.createAccount(accountEntity);
        return true;
    }

    @Override
    public String getPassword(AccountEntity accountEntity) throws Exception {
        Account account = accountRepository.getAccountWithNickAndAppId(accountEntity.getNickName(), accountEntity.getAppId());

        return account.getPassword();
    }


    @Override
    public Account create(Account account) throws Exception {
        return null;
    }

    @Override
    public void update(Map<String, Object> params) throws Exception {

    }


}
