package com.zxu.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单商品详情表
 */
@TableName("order_detail")
public class OrderDetail {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = t.order_id)
    private String orderId;//订单ID
    @TableField(value = t.item_id)
    private String itemId;//商品ID
    @TableField(value = t.item_name)
    private String itemName;//商品名
    @TableField(value = t.item_price)
    private BigDecimal itemPrice;//商品价格
    @TableField(value = t.amount)
    private BigDecimal amount;//购买数量
    @TableField(value = t.sum_money)
    private BigDecimal sumMoney;//金额小计
    @TableField(value = t.remark)
    private String remark;//商品备注
    @TableField(value = t.create_time)
    private Date createTime;//创建时间

    @TableField(value = t.user_id)
    private String userId;//
    @TableField(value = t.item_img_url)
    private String itemImgUrl;//

    public static class t {
        public static final String order_id = "order_id";
        public static final String item_id = "item_id";
        public static final String item_name = "item_name";
        public static final String item_price = "item_price";
        public static final String amount = "amount";
        public static final String sum_money = "sum_money";
        public static final String remark = "remark";
        public static final String create_time = "create_time";
        public static final String user_id = "user_id";
        public static final String item_img_url = "item_img_url";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(BigDecimal sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }
}
