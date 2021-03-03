package com.zxu.service;

import com.zxu.entity.Order;
import com.zxu.mapper.OrderMapper;
import com.zxu.service.usb.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order get() {
        Order order = orderMapper.selectList(null).get(0);
        return order;
    }
}
