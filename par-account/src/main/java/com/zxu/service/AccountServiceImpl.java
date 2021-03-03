package com.zxu.service;

import com.zxu.entity.Account;
import com.zxu.mapper.AccountMapper;
import com.zxu.service.usb.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account getAccount() {
        Account account = accountMapper.selectList(null).get(0);
        return account;

    }
}
