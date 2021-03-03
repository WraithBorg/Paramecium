package com.zxu.vo;

import java.util.List;

/**
 * 商品类别
 */
public class CategoryVO {
    private String catid;

    private String description;
    private Long ex_table_id;
    private String imgurl;
    private Integer orderindex;
    private String pid;
    private Integer status;
    private String title;
    private List<CategoryVO> child;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEx_table_id() {
        return ex_table_id;
    }

    public void setEx_table_id(Long ex_table_id) {
        this.ex_table_id = ex_table_id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public String getCatid() {
        return catid;
    }

    public void setCatid(String catid) {
        this.catid = catid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryVO> getChild() {
        return child;
    }

    public void setChild(List<CategoryVO> child) {
        this.child = child;
    }

}
