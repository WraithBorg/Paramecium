package com.zxu.entity;




import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName(value = "order_tbl")
public class Order {
    @TableId(value = t.id,type = IdType.AUTO)
    private Integer id;
    @TableField(value = t.userId)
    private String userId;
    @TableField(value = t.commodityCode)
    private String commodityCode;
    @TableField(value = t.count)
    private Integer count;
    @TableField(value = t.money)
    private BigDecimal money;
    public static final class t{
        private static final String id = "id";
        private static final String userId = "user_id";
        private static final String commodityCode = "commodity_code";
        private static final String count = "count";
        private static final String money = "money";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
