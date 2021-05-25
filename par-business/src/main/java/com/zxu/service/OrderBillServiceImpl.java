package com.zxu.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxu.client.AccountClient;
import com.zxu.client.StorageClient;
import com.zxu.constant.CConstant;
import com.zxu.domain.OrderBillDo;
import com.zxu.domain.OrderDetailDo;
import com.zxu.domain.OrderLogisticsDo;
import com.zxu.domain.ReceiptDo;
import com.zxu.domain.ShopCartItemDo;
import com.zxu.domain.UserDo;
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
import com.zxu.result.DockResult;
import com.zxu.service.usb.OrderBillService;
import com.zxu.util.BillNoUtil;
import com.zxu.util.CustomUtils;
import com.zxu.util.DDecimalUtil;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderBillServiceImpl implements OrderBillService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderBillServiceImpl.class);

    @Resource
    private OrderLogisticsMapper logisticsMapper;
    @Resource
    private OrderDetailMapper detailMapper;
    @Resource
    private OrderBillMapper billMapper;
    @Resource
    private ShopCartItemMapper shopCartItemMapper;
    @Resource
    private ReceiptInfoMapper receiptInfoMapper;
    @Resource
    private AccountClient accountClient;
    @Resource
    private StorageClient storageClient;

    /**
     * 创建订单
     */
    @GlobalTransactional
    @Override
    public void createOrder(UserDo currentUser, CreateOrderDTO dto) {

        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        // 创建订单
        List<ShopCartItemDo> cartItemInfos = createOrderBillInfo(currentUser, dto);
        // 下单完成 清空购物车
        cartItemInfos.forEach(m -> shopCartItemMapper.deleteById(m.getId()));
        
        // 减库存
        Map map3 = CustomUtils.ofMap(CConstant.COMMODITY_CODE, "160", CConstant.AMOUNT, 10);
        DockResult inventoryRes = storageClient.minusInventory(JSON.toJSONString(map3));
        if (inventoryRes.error()){
            throw new RuntimeException(inventoryRes.getMessage());
        }
        
        // 扣钱
        Map map2 = CustomUtils.ofMap(CConstant.USER_ID, "3", CConstant.AMOUNT, new BigDecimal(10));
        DockResult accountRes = accountClient.deduct(JSON.toJSONString(map2));
        if (accountRes.error()){
            throw new RuntimeException(accountRes.getMessage());
        }
    }

    private List<ShopCartItemDo> createOrderBillInfo(UserDo currentUser, CreateOrderDTO dto) {
        // Prepared
        List<String> cartIds = dto.getCartid();
        List<ShopCartItemDo> cartItemInfos = cartIds.stream().map(s -> shopCartItemMapper.selectById(s)).collect(Collectors.toList());
        BigDecimal totalAmount = cartItemInfos.stream().map(ShopCartItemDo::getAmount).reduce(BigDecimal::add).get();
        BigDecimal sumMoney = cartItemInfos.stream().map(m -> m.getAmount().multiply(m.getPrice())).reduce(BigDecimal::add).get();

        String billId = UUID.randomUUID().toString().replace("-", "");
        String logisticsId = UUID.randomUUID().toString().replace("-", "");
        // Install OrderBill And Save
        OrderBillDo orderBill = new OrderBillDo();
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
        for (ShopCartItemDo info : cartItemInfos) {
            OrderDetailDo dt = new OrderDetailDo();
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
        ReceiptDo receiptInfo = receiptInfoMapper.selectById(dto.getUser_address_id());
        OrderLogisticsDo logistics = new OrderLogisticsDo();
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
        return cartItemInfos;
    }


    @Override
    public List<OrderBillDo> getMyOrder(String userId, String type) {
        Integer state = OrderState.getId(type);
        if (state == null) {
            QueryWrapper<OrderBillDo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(OrderBillDo::getUserId, userId).ne(OrderBillDo::getState, OrderState.CANCELLED.id);
            return billMapper.selectList(queryWrapper);
        }
        QueryWrapper<OrderBillDo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(OrderBillDo::getUserId, userId).eq(OrderBillDo::getState, state);
        return billMapper.selectList(queryWrapper);

    }

    @Override
    public void cancelOrder(String id) {
        OrderBillDo orderBill = billMapper.selectById(id);
        orderBill.setState(OrderState.CANCELLED.id);
        billMapper.updateById(orderBill);
    }

    @Override
    public void clearOrder(String id) {
        OrderBillDo orderBill = billMapper.selectById(id);
        if (orderBill.getState().equals(OrderState.CANCELLED.id)) {
            billMapper.deleteById(id);
            logisticsMapper.deleteByMap(CustomUtils.ofMap(OrderLogisticsDo.t.order_id, id));
            detailMapper.deleteByMap(CustomUtils.ofMap(OrderLogisticsDo.t.order_id, id));
        }
    }

    @Override
    public OrderBillDo getOrder (String id) {
        return billMapper.selectById(id);
    }

    @Override
    public void payOrder (String id) {
        OrderBillDo orderBillDo = billMapper.selectById(id);
        orderBillDo.setState(OrderState.UN_SEND.id);
        billMapper.updateById(orderBillDo);
    }
}
