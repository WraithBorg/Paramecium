package com.zxu.vo;

import java.util.List;

/**
 * 订单列表 订单对象
 */
public class OrderBill4ListVO extends OrderBillVO {

    private OrderBillAddrVO addr;//收货地址
    private List<OrderDetailVO> prolist;//商品列表

    /******************************************/
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
