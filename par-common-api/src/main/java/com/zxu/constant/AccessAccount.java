package com.zxu.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 访问接口常量
 */
@Component
@PropertySource("classpath:access-account.properties")
public class AccessAccount {
    public static final String GET = "get";
    public static String HOST;

    @Value("${account.host}")
    public void setHOST(String HOST) {
        AccessAccount.HOST = HOST;
    }
}
