package com.zxu.vo;

import java.util.Date;

/**
 * 首页显示品项类别
 */
public class Category4IndexVO {
    private String id;
    private String title;
    private String info;
    private Date dateline = new Date();
    private Date starttime = new Date();
    private Date endtime = new Date();
    //    private String imgurl = PageConst.IMG_PATH + "book.png";
    private String imgurl = "book.png";
    private String imgurl2 = "";
    private String link1 = "../../pageb2c/b2c_product/list?catid=22";
    private String link2 = "../../pageb2c/b2c_product/list?catid=22";
    private String object_id = "0";
    private Integer orderindex = 0;
    private String price = "0.00";
    private Integer status = 2;
    private String tag_id = "6";
    private String tag_id_2nd = "8";
    private String checkbox_attr = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgurl2() {
        return imgurl2;
    }

    public void setImgurl2(String imgurl2) {
        this.imgurl2 = imgurl2;
    }

    public String getLink1() {
        return link1;
    }

    public void setLink1(String link1) {
        this.link1 = link1;
    }

    public String getLink2() {
        return link2;
    }

    public void setLink2(String link2) {
        this.link2 = link2;
    }

    public String getObject_id() {
        return object_id;
    }

    public void setObject_id(String object_id) {
        this.object_id = object_id;
    }

    public Integer getOrderindex() {
        return orderindex;
    }

    public void setOrderindex(Integer orderindex) {
        this.orderindex = orderindex;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_id_2nd() {
        return tag_id_2nd;
    }

    public void setTag_id_2nd(String tag_id_2nd) {
        this.tag_id_2nd = tag_id_2nd;
    }

    public String getCheckbox_attr() {
        return checkbox_attr;
    }

    public void setCheckbox_attr(String checkbox_attr) {
        this.checkbox_attr = checkbox_attr;
    }
}
