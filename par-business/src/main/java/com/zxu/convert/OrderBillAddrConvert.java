package com.zxu.convert;

import com.zxu.domain.OrderLogisticsDo;
import com.zxu.vo.OrderBillAddrVO;
import org.springframework.stereotype.Component;

@Component
public class OrderBillAddrConvert {

    OrderBillAddrVO getOrderBillAddrVO(OrderLogisticsDo info) {
        if (info == null) return null;
        OrderBillAddrVO vo = new OrderBillAddrVO();
        vo.setAddress(info.getCneeAddress());
        vo.setTruename(info.getCneeRealName());
        vo.setTelephone(info.getCneeTelephone());
        return vo;

    }
}
