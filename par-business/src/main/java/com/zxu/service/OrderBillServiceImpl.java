package com.zxu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxu.common.domain.OrderBill;
import com.zxu.common.domain.OrderDetail;
import com.zxu.common.domain.OrderLogistics;
import com.zxu.common.domain.ReceiptInfo;
import com.zxu.common.domain.ShopCartItemInfo;
import com.zxu.common.domain.UserInfo;
import com.zxu.dto.CreateOrderDTO;
import com.zxu.eum.DeliveryStatus;
import com.zxu.eum.OrderState;
import com.zxu.eum.PayType;
import com.zxu.mapper.OrderBillMapper;
import com.zxu.mapper.OrderDetailMapper;
import com.zxu.mapper.OrderLogisticsMapper;
import com.zxu.mapper.ReceiptInfoMapper;
import com.zxu.mapper.ShopCartItemMapper;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.service.usb.OrderBillService;
import com.zxu.util.BillNoUtil;
import com.zxu.util.CCommonUtils;
import com.zxu.util.DDecimalUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderBillServiceImpl implements OrderBillService {
    @Resource
    private OrderLogisticsMapper logisticsMapper;
    @Resource
    private OrderDetailMapper detailMapper;
    @Resource
    private OrderBillMapper billMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private ShopCartItemMapper shopCartItemMapper;
    @Resource
    private ReceiptInfoMapper receiptInfoMapper;

    /**
     * 创建订单
     */
    @Override
    public void createOrder(UserInfo currentUser, CreateOrderDTO dto) {

        // Prepared
        List<String> cartIds = dto.getCartid();
        List<ShopCartItemInfo> cartItemInfos = cartIds.stream().map(s -> shopCartItemMapper.selectById(s)).collect(Collectors.toList());
        BigDecimal totalAmount = cartItemInfos.stream().map(ShopCartItemInfo::getAmount).reduce(BigDecimal::add).get();
        BigDecimal sumMoney = cartItemInfos.stream().map(m -> m.getAmount().multiply(m.getPrice())).reduce(BigDecimal::add).get();

        String billId = UUID.randomUUID().toString().replace("-", "");
        String logisticsId = UUID.randomUUID().toString().replace("-", "");
        // Install OrderBill And Save
        OrderBill orderBill = new OrderBill();
        orderBill.setId(billId);
        orderBill.setCreateTime(new Date());
        orderBill.setOrderNo(BillNoUtil.createNo());
        orderBill.setLogisticsId(logisticsId);
        orderBill.setRemark(dto.getComment());
        orderBill.setSumMoney(DDecimalUtil.setScale(sumMoney));
        orderBill.setPayType(PayType.getId(dto.getPaytype()));
        orderBill.setPayMoney(DDecimalUtil.setScale(sumMoney));
        orderBill.setItemAmountTotal(DDecimalUtil.setScale(totalAmount));
        orderBill.setFreight(BigDecimal.ZERO);// TODO
        orderBill.setUserId(currentUser.getId());
        orderBill.setState(OrderState.UN_PAY.id);
        billMapper.insert(orderBill);
        // Install Detail And Save
        for (ShopCartItemInfo info : cartItemInfos) {
            OrderDetail dt = new OrderDetail();
            dt.setUserId(currentUser.getId());
            dt.setCreateTime(new Date());
            dt.setOrderId(billId);
            dt.setItemId(info.getItemId());
            dt.setItemName(info.getItemName());
            dt.setAmount(DDecimalUtil.setScale(info.getAmount()));
            dt.setSumMoney(DDecimalUtil.setScale(info.getAmount().multiply(info.getPrice())));
            dt.setItemPrice(info.getPrice());
            dt.setRemark("");//TODO
            dt.setItemImgUrl(info.getItemImgUrl());
            detailMapper.insert(dt);
        }
        //  Install OrderLogistics And Save
        ReceiptInfo receiptInfo = receiptInfoMapper.selectById(dto.getUser_address_id());
        OrderLogistics logistics = new OrderLogistics();
        logistics.setId(logisticsId);
        logistics.setOrderId(billId);
        logistics.setExpressNo(null);
        logistics.setCneeRealName(receiptInfo.getTrueName());
        logistics.setCneeTelephone(receiptInfo.getTelephone());
        logistics.setCneeAddress(receiptInfo.getAddress());
        logistics.setFreight(BigDecimal.ZERO);// TODO
        logistics.setDeliveryTime(null);
        logistics.setStatus(DeliveryStatus.WAIT_DELIVERY.id);
        logistics.setCreateTime(new Date());
        logistics.setUpdateTime(new Date());
        logisticsMapper.insert(logistics);
        // 下单完成 清空购物车
        cartItemInfos.forEach(m -> shopCartItemMapper.deleteById(m.getId()));
    }


    @Override
    public List<OrderBill> getMyOrder(String userId, String type) {
        Integer state = OrderState.getId(type);
        if (state == null) {
            QueryWrapper<OrderBill> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(OrderBill::getUserId, userId).ne(OrderBill::getState, OrderState.CANCELLED.id);
            return billMapper.selectList(queryWrapper);
        }
        QueryWrapper<OrderBill> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(OrderBill::getUserId, userId).eq(OrderBill::getState, state);
        return billMapper.selectList(queryWrapper);

    }

    @Override
    public void cancelOrder(String id) {
        OrderBill orderBill = billMapper.selectById(id);
        orderBill.setState(OrderState.CANCELLED.id);
        billMapper.updateById(orderBill);
    }

    @Override
    public void clearOrder(String id) {
        OrderBill orderBill = billMapper.selectById(id);
        if (orderBill.getState().equals(OrderState.CANCELLED.id)) {
            billMapper.deleteById(id);
            logisticsMapper.deleteByMap(CCommonUtils.ofMap(OrderLogistics.t.order_id, id));
            detailMapper.deleteByMap(CCommonUtils.ofMap(OrderLogistics.t.order_id, id));
        }
    }
}
