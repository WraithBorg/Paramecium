package com.zxu.vo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ConfirmDetailVO {
    private List<ReceiptInfoVO> addrList;//收货地址列表
    private List<ShopCartItemVO> cartList;//购物车明细列表
    private  Map<String,String> paytypeList;//支付方式列表
    private List couponList = null;
    private BigDecimal express_money = BigDecimal.ZERO;//邮费
    private Integer ispin = 0;//拼单
    private String pin_orderid;//拼单ID
    private String paytype = "alipay";//支付方式
    private BigDecimal goods_money;//商品总金额
    private BigDecimal total_money;//商品总金额
    private BigDecimal total_num;//商品总数量
    private String user_address_id;//收货地址
    private Boolean vipcard = false;//VIP卡
    private BigDecimal weight = BigDecimal.ZERO;//重量

    public List<ReceiptInfoVO> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<ReceiptInfoVO> addrList) {
        this.addrList = addrList;
    }

    public List<ShopCartItemVO> getCartList() {
        return cartList;
    }

    public void setCartList(List<ShopCartItemVO> cartList) {
        this.cartList = cartList;
    }

    public Map<String, String> getPaytypeList() {
        return paytypeList;
    }

    public void setPaytypeList(Map<String, String> paytypeList) {
        this.paytypeList = paytypeList;
    }

    public List getCouponList() {
        return couponList;
    }

    public void setCouponList(List couponList) {
        this.couponList = couponList;
    }

    public BigDecimal getExpress_money() {
        return express_money;
    }

    public void setExpress_money(BigDecimal express_money) {
        this.express_money = express_money;
    }

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

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public BigDecimal getGoods_money() {
        return goods_money;
    }

    public void setGoods_money(BigDecimal goods_money) {
        this.goods_money = goods_money;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public BigDecimal getTotal_num() {
        return total_num;
    }

    public void setTotal_num(BigDecimal total_num) {
        this.total_num = total_num;
    }

    public String getUser_address_id() {
        return user_address_id;
    }

    public void setUser_address_id(String user_address_id) {
        this.user_address_id = user_address_id;
    }

    public Boolean getVipcard() {
        return vipcard;
    }

    public void setVipcard(Boolean vipcard) {
        this.vipcard = vipcard;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
