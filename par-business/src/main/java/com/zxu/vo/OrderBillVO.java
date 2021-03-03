package com.zxu.vo;

import java.math.BigDecimal;

public class OrderBillVO {

    private String comment;//订单备注
    private String createtime;//创建时间
    private String goods_money;//货品金额
    private Integer ispay;//付款状态
    private String money;//货品金额
    private String orderid;//订单ID
    private String orderno;//订单单号
    private String paytype;// 支付方式
    private String paymoney;// 支付金额
    private BigDecimal total_num;//商品总数量
    private String user_address_id;//收货地址
    private String userid;//用户
    private String express_no;//快递单号
    private Integer isreceived;//是否收货
    private String express_money;//运费
    private String status_name;//付款状态
    private Integer status;//付款状态
    //
    private String weight = "0.00";//商品重量
    private Integer coupon_id = 0;//优惠券ID
    private Integer daySn = 57;
    private String discount_money = "0.00";//折扣金额
    private String coupon_money = "0.00";//优惠券金额
    private Integer israty = 0;
    private String productid = "0";//商品
    private Integer ispin = 0;//是否拼单
    private Integer pin_num = 0;//拼单数量
    private String pin_orderid = "0";//拼单id
    private Integer pin_success = 0;//拼单成功标记
    private String recharge_id = "0";//充值
    private String timeago = "1分前";//订单创建间隔
    private String vipmoney = "0.00";//vip金额
    private String whocancel = "";

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getGoods_money() {
        return goods_money;
    }

    public void setGoods_money(String goods_money) {
        this.goods_money = goods_money;
    }

    public Integer getIspay() {
        return ispay;
    }

    public void setIspay(Integer ispay) {
        this.ispay = ispay;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(String paymoney) {
        this.paymoney = paymoney;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    public Integer getIsreceived() {
        return isreceived;
    }

    public void setIsreceived(Integer isreceived) {
        this.isreceived = isreceived;
    }

    public String getExpress_money() {
        return express_money;
    }

    public void setExpress_money(String express_money) {
        this.express_money = express_money;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Integer getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(Integer coupon_id) {
        this.coupon_id = coupon_id;
    }

    public Integer getDaySn() {
        return daySn;
    }

    public void setDaySn(Integer daySn) {
        this.daySn = daySn;
    }

    public String getDiscount_money() {
        return discount_money;
    }

    public void setDiscount_money(String discount_money) {
        this.discount_money = discount_money;
    }

    public String getCoupon_money() {
        return coupon_money;
    }

    public void setCoupon_money(String coupon_money) {
        this.coupon_money = coupon_money;
    }

    public Integer getIsraty() {
        return israty;
    }

    public void setIsraty(Integer israty) {
        this.israty = israty;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Integer getIspin() {
        return ispin;
    }

    public void setIspin(Integer ispin) {
        this.ispin = ispin;
    }

    public Integer getPin_num() {
        return pin_num;
    }

    public void setPin_num(Integer pin_num) {
        this.pin_num = pin_num;
    }

    public String getPin_orderid() {
        return pin_orderid;
    }

    public void setPin_orderid(String pin_orderid) {
        this.pin_orderid = pin_orderid;
    }

    public Integer getPin_success() {
        return pin_success;
    }

    public void setPin_success(Integer pin_success) {
        this.pin_success = pin_success;
    }

    public String getRecharge_id() {
        return recharge_id;
    }

    public void setRecharge_id(String recharge_id) {
        this.recharge_id = recharge_id;
    }

    public String getTimeago() {
        return timeago;
    }

    public void setTimeago(String timeago) {
        this.timeago = timeago;
    }

    public String getVipmoney() {
        return vipmoney;
    }

    public void setVipmoney(String vipmoney) {
        this.vipmoney = vipmoney;
    }

    public String getWhocancel() {
        return whocancel;
    }

    public void setWhocancel(String whocancel) {
        this.whocancel = whocancel;
    }
}
