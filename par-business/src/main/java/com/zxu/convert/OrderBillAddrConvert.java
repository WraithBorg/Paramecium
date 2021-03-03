package com.zxu.convert;

import com.zxu.domain.OrderLogistics;
import com.zxu.vo.OrderBillAddrVO;
import org.springframework.stereotype.Component;

@Component
public class OrderBillAddrConvert {

    OrderBillAddrVO getOrderBillAddrVO(OrderLogistics info) {
        OrderBillAddrVO vo = new OrderBillAddrVO();
        vo.setAddress(info.getCneeAddress());
        vo.setTruename(info.getCneeRealName());
        vo.setTelephone(info.getCneeTelephone());
        return vo;

    }
}
