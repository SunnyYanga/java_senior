package com.yang.service;

import com.yang.domain.Account;

import java.util.List;

/**
 * @author yg
 * @date 2020/4/30 9:09
 */
public interface AccountService {

    List<Account> findAll();

    void saveAccount(Account account);
}
