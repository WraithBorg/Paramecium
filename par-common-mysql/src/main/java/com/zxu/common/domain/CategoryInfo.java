package com.zxu.common.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "category_info")
public class CategoryInfo {
    @TableId
    private String id;
    @TableField(value = t.name)
    private String name;
    @TableField(value = t.pid)
    private String pid;
    @TableField(value = t.img_url)
    private String imgUrl;

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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public final static class t {
        public static final String name = "name";
        public static final String pid = "pid";
        public static final String img_url = "img_url";
    }
}
