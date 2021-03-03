package com.zxu.vo;

import java.math.BigDecimal;

/**
 * 购物车明细
 */
public class ShopCartItemVO {
    private Integer amount;
    private String createtime;
    private Integer etime;
    private String id;
    private String imgurl;
    private String ks_title;
    private Long ksid;
    private String otype;
    private String price;
    private String productid;
    private String pt_price;
    private Integer stime;
    private String title;
    private Integer total_num;
    private String userid;
    private BigDecimal weight;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getEtime() {
        return etime;
    }

    public void setEtime(Integer etime) {
        this.etime = etime;
    }


    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getKs_title() {
        return ks_title;
    }

    public void setKs_title(String ks_title) {
        this.ks_title = ks_title;
    }

    public Long getKsid() {
        return ksid;
    }

    public void setKsid(Long ksid) {
        this.ksid = ksid;
    }

    public String getOtype() {
        return otype;
    }

    public void setOtype(String otype) {
        this.otype = otype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getPt_price() {
        return pt_price;
    }

    public void setPt_price(String pt_price) {
        this.pt_price = pt_price;
    }

    public Integer getStime() {
        return stime;
    }

    public void setStime(Integer stime) {
        this.stime = stime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
