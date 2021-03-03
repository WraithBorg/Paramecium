package com.zxu.constant;

import java.util.HashMap;

/**
 * 系统常量
 */
public class CConstant {
    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";
    public static final String TELEPHONE = "telePhone";
    public static final String PASSWORD = "password";
    public static final HashMap PAY_TYPE = new HashMap(){{
        put("alipay", "支付宝");
    }};
}
