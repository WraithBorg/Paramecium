package com.zxu.dto;

import java.util.List;

public class CreateOrderDTO {
    private Integer ispin;
    private String pin_orderid;
    private String user_address_id;
    private String paytype;
    private String comment;
    private String backurl;
    private List<String> cartid;

    public Integer getIspin() {
        return ispin;
    }

    public void setIspin(Integer ispin) {
        this.ispin = ispin;
    }

    public String getPin_orderid() {
        return pin_orderid;
    }

    public void setPin_orderid(String pin_orderid) {
        this.pin_orderid = pin_orderid;
    }

    public String getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(String user_address_id) {
        this.user_address_id = user_address_id;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl;
    }

    public List<String> getCartid() {
        return cartid;
    }

    public void setCartid(List<String> cartid) {
        this.cartid = cartid;
    }
}
