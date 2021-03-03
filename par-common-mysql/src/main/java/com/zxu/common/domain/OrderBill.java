package com.zxu.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */
@TableName("order_bill")
public class OrderBill {
    @TableId
    private String id;
    @TableField(value = t.order_no)
    private String orderNo;//订单编号
    @TableField(value = t.trade_no)
    private String tradeNo;//
    @TableField(value = t.logistics_id)
    private String logisticsId;//物流信息
    @TableField(value = t.remark)
    private String remark;//订单备注
    @TableField(value = t.sum_money)
    private BigDecimal sumMoney;//订单金额
    @TableField(value = t.pay_type)
    private Integer payType;//支付类型
    @TableField(value = t.pay_money)
    private BigDecimal payMoney;//支付金额
    @TableField(value = t.item_amount_total)
    private BigDecimal itemAmountTotal;//订单商品数量合计
    @TableField(value = t.freight)
    private BigDecimal freight;//运费

    @TableField(value = t.create_time)
    private Date createTime;//创建时间
    @TableField(value = t.user_id)
    private String userId;//
    @TableField(value = t.state)
    private Integer state;//状态

    public static class t {
        public static final String order_no = "order_no";//订单编号
        public static final String trade_no = "trade_no";//支付订单流水号
        public static final String logistics_id = "logistics_id";//物流信息
        public static final String remark = "remark";//订单备注
        public static final String sum_money = "sum_money";//订单金额
        public static final String pay_type = "pay_type";//支付类型
        public static final String pay_money = "pay_money";//支付金额
        public static final String item_amount_total = "item_amount_total";//订单商品数量合计
        public static final String freight = "freight";//运费
        public static final String pay_status = "pay_status";//支付状态
        public static final String create_time = "create_time";//创建时间
        public static final String user_id = "user_id";//创建时间
        public static final String state = "state";//订单状态
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getItemAmountTotal() {
        return itemAmountTotal;
    }

    public void setItemAmountTotal(BigDecimal itemAmountTotal) {
        this.itemAmountTotal = itemAmountTotal;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }


    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
