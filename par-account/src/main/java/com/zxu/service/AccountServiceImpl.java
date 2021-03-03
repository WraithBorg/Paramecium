package com.zxu.service;

import com.zxu.domain.AccountDo;
import com.zxu.mapper.AccountMapper;
import com.zxu.service.usb.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public AccountDo getAccount() {
        AccountDo account = accountMapper.selectList(null).get(0);
        return account;

    }
}
