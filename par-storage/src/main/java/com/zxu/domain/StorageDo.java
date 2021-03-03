package com.zxu.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "storage_tbl")
public class StorageDo {
    @TableId(value = t.id,type = IdType.AUTO)
    private Integer id;
    @TableField(value = t.commodityCode)
    private String commodityCode;
    @TableField(value = t.count)
    private Integer count;
    public static class t {
        public static final String id = "id";
        public static final String commodityCode = "commodity_code";
        public static final String count = "count";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
