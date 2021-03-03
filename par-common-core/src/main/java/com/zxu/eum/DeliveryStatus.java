package com.zxu.eum;

/**
 * 发货状态枚举
 */
public enum DeliveryStatus {
    WAIT_DELIVERY(101),//"待发货"
    DELIVERED(205),//已发货
    RECEIVED(302),//已收货
    ;
    public Integer id;


    DeliveryStatus(Integer id) {
        this.id = id;
    }

    public static Integer isReceived(Integer id) {
        if (id.equals(RECEIVED.id)) {
            return 1;
        }
        return 0;
    }
}
