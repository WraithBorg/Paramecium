package com.zxu.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户收藏表
 */
@TableName("user_fav_item")
public class UserFavItemInfo {
    @TableId
    private String id;
    @TableField(value = t.user_id)
    private String userId;
    @TableField(value = t.item_id)
    private String itemId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static final class t {
        public static final String item_id = "item_id";
        public static final String user_id = "user_id";
    }

}
