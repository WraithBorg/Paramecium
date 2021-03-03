package com.zxu;

import com.zxu.client.AccountClient;
import com.zxu.client.OrderClient;
import com.zxu.client.StorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BusinessTemplate {
    @Resource
    private AccountClient accountClient;
    @Resource
    private OrderClient orderClient;
    @Resource
    private StorageClient storageClient;
    @Test
    public void getAccount() {
        accountClient.create();
        orderClient.create();
        storageClient.create();
    }
}
