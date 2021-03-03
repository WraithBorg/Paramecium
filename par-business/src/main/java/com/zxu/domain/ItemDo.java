package com.zxu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName(value = "item_info")
public class ItemDo {
    @TableId
    private String id;
    @TableField(value = t.name)
    private String name;
    @TableField(value = t.price)
    private BigDecimal price;
    @TableField(value = t.weight)
    private BigDecimal weight;
    @TableField(value = t.category_id)
    private Long categoryId;
    @TableField(value = t.buy_num)
    private Integer buyNum;
    @TableField(value = t.content)
    private String content;





    @TableField(exist = false)
    private String defaultImg;


    public String getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(String defaultImg) {
        this.defaultImg = defaultImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public static final class t {
        public static final String name = "name";
        public static final String price = "price";
        public static final String weight = "weight";
        public static final String category_id = "category_id";
        public static final String buy_num = "buy_num";
        public static final String content = "content";
    }
}
