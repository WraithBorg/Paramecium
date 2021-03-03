package com.zxu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物流信息表
 */

@TableName("order_logistics")
public class OrderLogisticsDo {
    @TableId
    private String id;
    @TableField(value = t.order_id)
    private String orderId;
    @TableField(value = t.express_no)
    private String expressNo;
    @TableField(value = t.cnee_realname)
    private String cneeRealName;
    @TableField(value = t.cnee_telephone)
    private String cneeTelephone;
    @TableField(value = t.cnee_address)
    private String cneeAddress;
    @TableField(value = t.freight)
    private BigDecimal freight;
    @TableField(value = t.delivery_time)
    private Date deliveryTime;
    @TableField(value = t.update_time)
    private Date updateTime;
    @TableField(value = t.create_time)
    private Date createTime;
    @TableField(value = t.status)
    private Integer status;

    public static class t {
        public static final String order_id = "order_id";
        public static final String express_no = "express_no";//快递单号
        public static final String cnee_realname = "cnee_realname";//收货人姓名
        public static final String cnee_telephone = "cnee_telephone";//收货人手机号
        public static final String cnee_address = "cnee_address";//收货人地址
        public static final String freight = "freight";//运费
        public static final String delivery_time = "delivery_time";//发货时间
        public static final String create_time = "create_time";
        public static final String update_time = "update_time";//物流更新时间
        public static final String status = "status";//物流状态
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

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getCneeRealName() {
        return cneeRealName;
    }

    public void setCneeRealName(String cneeRealName) {
        this.cneeRealName = cneeRealName;
    }

    public String getCneeTelephone() {
        return cneeTelephone;
    }

    public void setCneeTelephone(String cneeTelephone) {
        this.cneeTelephone = cneeTelephone;
    }

    public String getCneeAddress() {
        return cneeAddress;
    }

    public void setCneeAddress(String cneeAddress) {
        this.cneeAddress = cneeAddress;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
