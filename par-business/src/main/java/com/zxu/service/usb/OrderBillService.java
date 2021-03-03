package com.zxu.service.usb;

import com.zxu.common.domain.OrderBill;
import com.zxu.common.domain.UserInfo;
import com.zxu.dto.CreateOrderDTO;

import java.util.List;

public interface OrderBillService {
    /**
     * 创建订单
     */
    void createOrder(UserInfo currentUser, CreateOrderDTO createOrderDTO);
    /**
     * 查询订单列表
     */
    List<OrderBill> getMyOrder(String userId, String type);
    /**
     * 取消订单
     */
    void cancelOrder(String id);
    /**
     * 清除已取消订单
     */
    void clearOrder(String orderid);
}
