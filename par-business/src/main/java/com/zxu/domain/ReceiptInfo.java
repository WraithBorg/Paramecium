package com.zxu.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("receipt_info")
public class ReceiptInfo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    @TableField(value = t.user_id)
    private String userId;
    @TableField(value = t.address)
    private String address;
    @TableField(value = t.zip_code)
    private String zipCode;
    @TableField(value = t.true_name)
    private String trueName;
    @TableField(value = t.telephone)
    private String telephone;
    @TableField(value = t.province_id)
    private Integer provinceId;
    @TableField(value = t.city_id)
    private Integer cityId;
    @TableField(value = t.town_id)
    private Integer townId;
    @TableField(value = t.default_flag)
    private Integer defaultFlag;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }
    public static final class t {
        public static final String user_id = "user_id";
        public static final String address = "address";
        public static final String zip_code = "zip_code";
        public static final String true_name = "true_name";
        public static final String telephone = "telephone";
        public static final String province_id = "province_id";
        public static final String city_id = "city_id";
        public static final String town_id = "town_id";
        public static final String default_flag = "default_flag";


    }

}
