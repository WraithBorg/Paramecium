package com.zxu.vo;

import java.util.List;

/**
 * 订单详情
 */
public class ShowOrderGroupVO   {
    private OrderBillVO order;//订单对象
    private OrderBillAddrVO addr;//收货地址
    private List<OrderDetailVO> prolist;//商品列表

    public OrderBillVO getOrder() {
        return order;
    }

    public void setOrder(OrderBillVO order) {
        this.order = order;
    }

    public OrderBillAddrVO getAddr() {
        return addr;
    }

    public void setAddr(OrderBillAddrVO addr) {
        this.addr = addr;
    }

    public List<OrderDetailVO> getProlist() {
        return prolist;
    }

    public void setProlist(List<OrderDetailVO> prolist) {
        this.prolist = prolist;
    }
}
