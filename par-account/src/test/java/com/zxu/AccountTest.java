package com.zxu;

import com.alibaba.fastjson.JSON;
import com.zxu.domain.AccountDo;
import com.zxu.service.usb.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AccountTest {
    @Resource
    private AccountService accountService;
    @Test
    public void testGet() {
        AccountDo account = accountService.getAccount();
        System.out.println(JSON.toJSONString(account));
    }
}
