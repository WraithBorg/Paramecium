package com.zxu;

import com.alibaba.fastjson.JSON;
import com.zxu.domain.OrderDo;
import com.zxu.service.usb.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderTest {
    @Resource
    private OrderService orderService;
    @Test
    public void testGet() {
        OrderDo account = orderService.get();
        System.out.println(JSON.toJSONString(account));
    }
    
}
