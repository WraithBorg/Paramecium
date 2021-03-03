package com.zxu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 客服记录
 */
@TableName("kefu_log")
public class KeFuLogDo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = "user_id")
    private String userId;
    @TableField(value = "create_time")
    private Date createTime;
    @TableField(value = "status")
    private Integer status;
    @TableField(value = "content")
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public static class t{
        public static final String user_id = "user_id";
        public static final String create_time = "create_time";
        public static final String status = "status";
        public static final String content = "content";
    }
}
