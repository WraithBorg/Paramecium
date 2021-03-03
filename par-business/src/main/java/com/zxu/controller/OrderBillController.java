package com.zxu.controller;

import com.zxu.SessionUtil;
import com.zxu.common.domain.OrderBill;
import com.zxu.common.domain.ReceiptInfo;
import com.zxu.common.domain.ShopCartItemInfo;
import com.zxu.common.domain.UserInfo;
import com.zxu.constant.CConstant;
import com.zxu.constant.PageConst;
import com.zxu.convert.OrderBill4ListConvert;
import com.zxu.convert.ReceiptInfoConvert;
import com.zxu.convert.ShoppingCartItemConvert;
import com.zxu.convert.ShowOrderGroupConvert;
import com.zxu.dto.CreateOrderDTO;
import com.zxu.mapper.OrderBillMapper;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.OrderBillService;
import com.zxu.service.usb.ReceiptInfoService;
import com.zxu.service.usb.ShopCartItemService;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CCommonUtils;
import com.zxu.vo.ConfirmDetailVO;
import com.zxu.vo.OrderBill4ListVO;
import com.zxu.vo.ReceiptInfoVO;
import com.zxu.vo.ShopCartItemVO;
import com.zxu.vo.ShowOrderGroupVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrderBillController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private ReceiptInfoConvert receiptConvert;
    @Resource
    private ReceiptInfoService receiptInfoService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private ShopCartItemService shopCartItemService;
    @Resource
    private ShoppingCartItemConvert cartItemConvert;
    @Resource
    private OrderBillService orderBillService;
    @Resource
    private OrderBillMapper orderBillMapper;
    @Resource
    private OrderBill4ListConvert orderBill4ListConvert;
    @Resource
    private ShowOrderGroupConvert showOrderGroupConvert;

    /**
     * 确认订单 显示商品和收货地址界面
     */
    @GetMapping("/b2c_order/confirm")
    public MsgResult confirm(@RequestParam(required = false) String user_address_id) {
        // 获取登陆人信息
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        // 查询收货地址列表
        List<ReceiptInfo> receiptInfos = receiptInfoService.selectList(defaultUser.getId());
        List<ReceiptInfoVO> receiptVOS = receiptConvert.getReceiptVOS(receiptInfos);
        // 查询购物车列表
        List<ShopCartItemInfo> cartItemInfos = shopCartItemService.getShopCartInfo(defaultUser.getId());
        List<ShopCartItemVO> cartList = cartItemConvert.getShoppingCartItemVOS(cartItemInfos);
        // 查询支付方式列表
        Map<String, String> payType = CConstant.PAY_TYPE;
        // 计算金额 数量
        BigDecimal totalMoney = cartItemInfos.stream().map(m -> m.getAmount().multiply(m.getPrice())).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalNum = cartItemInfos.stream().map(ShopCartItemInfo::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal goodsMoney = totalMoney;
        // 设置默认值
        String defaultAddressId = user_address_id;// 默认收货地址
        if (CCommonUtils.isBlank(defaultAddressId) && receiptVOS.size() > 0) {
            defaultAddressId = receiptVOS.get(0).getId();
        }
        String defaultPayType = null; // 默认支付方式
        if (payType.keySet().size() > 0) {
            String key = payType.keySet().stream().findFirst().get();
            defaultPayType = payType.get(key);
        }

        //
        ConfirmDetailVO confirmDetailVO = new ConfirmDetailVO();
        confirmDetailVO.setAddrList(receiptVOS);
        confirmDetailVO.setPaytypeList(payType);
        confirmDetailVO.setCartList(cartList);
        confirmDetailVO.setTotal_money(totalMoney);
        confirmDetailVO.setTotal_num(totalNum);
        confirmDetailVO.setGoods_money(goodsMoney);
        confirmDetailVO.setPaytype(defaultPayType);
        confirmDetailVO.setUser_address_id(defaultAddressId);

        return MsgResult.doneUrl(confirmDetailVO, PageConst.ORDER_CONFIRM);
    }

    /**
     * 查询我的订单
     */
    @GetMapping("/b2c_order/myorder")
    public MsgResult myorder(String type) {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        List<OrderBill> myOrder = orderBillService.getMyOrder(defaultUser.getId(), type);
        List<OrderBill4ListVO> orderBillVOS = orderBill4ListConvert.getOrderBill4ListVOS(myOrder);
        Map<String, Object> data = CCommonUtils.ofMap("type", type, "per_page", 0, "list", orderBillVOS);
        return MsgResult.doneUrl(data, PageConst.ORDER_LIST);
    }

    /**
     * 创建订单
     */
    @PostMapping("/b2c_order/createorder")
    public Object createOrder(CreateOrderDTO createOrderDTO) {
        UserInfo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        orderBillService.createOrder(currentUser, createOrderDTO);
        return null;
    }

    /**
     * 查看订单详情
     */
    @GetMapping("/b2c_order/showdetails")
    public MsgResult showDetail(String orderid) {
        ShowOrderGroupVO showOrderGroup = showOrderGroupConvert.getShowOrderGroup(orderid);
        orderBillService.clearOrder(orderid);
        return MsgResult.doneUrl(showOrderGroup, PageConst.ORDER_DETAIL_SHOW + orderid);
    }

    /**
     * 取消订单
     */
    @GetMapping("/b2c_order/cancelOrder")
    public Object cancelOrder(String orderid) {
        orderBillService.cancelOrder(orderid);
        return MsgResult.doneUrl(new ArrayList<>(), PageConst.ORDER_DETAIL_SHOW + orderid);
    }
}
