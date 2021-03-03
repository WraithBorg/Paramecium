package com.zxu.service;

import com.zxu.domain.AccountDo;
import com.zxu.mapper.AccountMapper;
import com.zxu.service.usb.AccountService;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    /**
     * 查询余额
     */
    @Override
    public AccountDo getAccount(String userId) {
        List<AccountDo> accountDos = accountMapper.selectByMap(CustomUtils.ofMap(AccountDo.t.user_id, userId));
        if (accountDos.size() == 0) {
            AccountDo accountDo = new AccountDo();
            accountDo.setUserId(userId);
            accountDo.setMoney(BigDecimal.ZERO);
            accountMapper.insert(accountDo);
            return accountDo;
        }
        return accountDos.get(0);

    }
    /**
     * 扣款
     */
    @Override
    public void deduct(String userId, BigDecimal amount) {
        AccountDo account = getAccount(userId);
        account.setMoney(account.getMoney().subtract(amount));
        accountMapper.updateById(account);
    }
    /**
     * 充值
     */
    @Override
    public void charge(String userId, BigDecimal amount) {
        AccountDo account = getAccount(userId);
        account.setMoney(account.getMoney().add(amount));
        accountMapper.updateById(account);
    }
}
