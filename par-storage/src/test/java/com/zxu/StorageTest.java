package com.zxu;

import com.alibaba.fastjson.JSON;
import com.zxu.domain.StorageDo;
import com.zxu.service.usb.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StorageTest {
    @Resource
    private StorageService storageService;
    @Test
    public void testGet() {
    }
}
