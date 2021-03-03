package com.zxu.service.usb;

import com.zxu.domain.AccountDo;

import java.math.BigDecimal;

public interface AccountService {
    public AccountDo getAccount(String userId);

    void deduct(String userId, BigDecimal amount);

    void charge(String userId, BigDecimal amount);
}
