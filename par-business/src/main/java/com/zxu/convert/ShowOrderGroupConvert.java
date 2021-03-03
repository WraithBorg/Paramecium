package com.zxu.convert;

import com.zxu.domain.OrderBill;
import com.zxu.domain.OrderDetail;
import com.zxu.domain.OrderLogistics;
import com.zxu.mapper.OrderBillMapper;
import com.zxu.mapper.OrderDetailMapper;
import com.zxu.mapper.OrderLogisticsMapper;
import com.zxu.util.CustomUtils;
import com.zxu.vo.OrderBillAddrVO;
import com.zxu.vo.OrderBillVO;
import com.zxu.vo.OrderDetailVO;
import com.zxu.vo.ShowOrderGroupVO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ShowOrderGroupConvert {
    @Resource
    private OrderBillAddrConvert orderBillAddrConvert;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private OrderDetailConvert orderDetailConvert;
    @Resource
    private OrderLogisticsMapper logisticsMapper;
    @Resource
    private OrderBillConvert orderBillConvert;
    @Resource
    private OrderBillMapper orderBillMapper;

    /**
     * 查看订单详情
     */
    public ShowOrderGroupVO getShowOrderGroup(String orderId) {
        //
        OrderLogistics logistics = logisticsMapper.getByOrderId(orderId);
        OrderBillAddrVO orderBillAddrVO = orderBillAddrConvert.getOrderBillAddrVO(logistics);
        //
        List<OrderDetail> orderDetails = orderDetailMapper.selectByMap(CustomUtils.ofMap(OrderDetail.t.order_id, orderId));
        List<OrderDetailVO> orderDetailVOS = orderDetailConvert.getOrderDetailVOS(orderDetails);
        //
        OrderBill orderBill = orderBillMapper.selectById(orderId);
        OrderBillVO orderBillVO = orderBillConvert.getOrderBill4ListVO(orderBill);
        //
        ShowOrderGroupVO vo = new ShowOrderGroupVO();
        vo.setAddr(orderBillAddrVO);
        vo.setOrder(orderBillVO);
        vo.setProlist(orderDetailVOS);
        return vo;
    }
}
