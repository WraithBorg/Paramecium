package com.zxu.common.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车明细
 */
@TableName("shop_cart_item")
public class ShopCartItemInfo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = t.amount)
    private BigDecimal amount;
    @TableField(value = t.price)
    private BigDecimal price;
    @TableField(value = t.create_time)
    private Date createTime;
    @TableField(value = t.item_name)
    private String itemName;
    @TableField(value = t.user_id)
    private String userId;
    @TableField(value = t.item_id)
    private String itemId;
    @TableField(value = t.item_img_url)
    private String itemImgUrl;

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public static class t {

        public static final String amount = "amount";
        public static final String price = "price";
        public static final String item_id = "item_id";
        public static final String item_img_url = "item_img_url";
        public static final String user_id = "user_id";
        public static final String item_name = "item_name";
        public static final String create_time = "create_time";
    }
}
