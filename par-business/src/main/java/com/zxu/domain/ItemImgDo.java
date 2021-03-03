package com.zxu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("item_img")
public class ItemImgDo {
    @TableId
    private String id;
    @TableField(value = t.item_id)
    private Long itemId;
    @TableField(value = t.default_flag)
    private Boolean defaultFlag;
    @TableField(value = t.url)
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Boolean getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Boolean defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public static final class t{
        public static final String item_id = "item_id";
        public static final String default_flag = "default_flag";
        public static final String url = "url";
    }
}
