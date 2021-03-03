package com.zxu.convert;

import com.zxu.domain.OrderBillDo;
import com.zxu.domain.OrderDetailDo;
import com.zxu.domain.OrderLogisticsDo;
import com.zxu.eum.DeliveryStatus;
import com.zxu.mapper.OrderDetailMapper;
import com.zxu.mapper.OrderLogisticsMapper;
import com.zxu.util.CustomUtils;
import com.zxu.vo.OrderBill4ListVO;
import com.zxu.vo.OrderBillAddrVO;
import com.zxu.vo.OrderDetailVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderBill4ListConvert {
    @Resource
    private OrderBillAddrConvert orderBillAddrConvert;
    @Resource
    private OrderLogisticsMapper logisticsMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private OrderDetailConvert orderDetailConvert;
    @Resource
    private OrderBillConvert orderBillConvert;

    /**
     * vo
     */
    public OrderBill4ListVO getOrderBill4ListVO(OrderBillDo info) {
        OrderBill4ListVO vo = orderBillConvert.getOrderBill4ListVO(info);
        // 收货地址
        OrderLogisticsDo logistics = logisticsMapper.getByOrderId(info.getId());
        if (logistics != null) {
            vo.setExpress_no(logistics.getExpressNo());
            vo.setIsreceived(DeliveryStatus.isReceived(logistics.getStatus()));
            //
            OrderBillAddrVO orderBillAddrVO = orderBillAddrConvert.getOrderBillAddrVO(logistics);
            vo.setAddr(orderBillAddrVO);
        }
        // 商品明细
        List<OrderDetailDo> orderDetails = orderDetailMapper.selectByMap(CustomUtils.ofMap(OrderDetailDo.t.order_id, info.getId()));
        List<OrderDetailVO> orderDetailVOS = orderDetailConvert.getOrderDetailVOS(orderDetails);
        vo.setProlist(orderDetailVOS);
        return vo;
    }

    public List<OrderBill4ListVO> getOrderBill4ListVOS(List<OrderBillDo> infos) {
        List<OrderBill4ListVO> collect = infos.stream().map(this::getOrderBill4ListVO).collect(Collectors.toList());
        return collect;
    }

}
