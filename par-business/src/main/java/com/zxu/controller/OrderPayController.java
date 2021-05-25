package com.zxu.controller;

import com.zxu.constant.PageConst;
import com.zxu.convert.ShowOrderGroupConvert;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.OrderBillService;
import com.zxu.vo.ShowOrderGroupVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderPayController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private OrderBillService orderBillService;
    @Resource
    private ShowOrderGroupConvert showOrderGroupConvert;

    /**
     * 订单支付
     */
    @GetMapping("/b2c_order/payOrder")
    public Object payOrder (@RequestParam("orderid") String orderid) {
        orderBillService.payOrder(orderid);
        ShowOrderGroupVO showOrderGroup = showOrderGroupConvert.getShowOrderGroup(orderid);
        return MsgResult.doneUrl(showOrderGroup, PageConst.ORDER_DETAIL_SHOW + orderid);
    }

}
