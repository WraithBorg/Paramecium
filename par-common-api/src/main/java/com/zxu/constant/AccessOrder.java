package com.zxu.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 访问接口常量
 */
@Component
@PropertySource("classpath:access-order.properties")
public class AccessOrder {
    public static final String GET = "get";
    public static String HOST;

    @Value("${order.host}")
    public void setHOST(String HOST) {
        AccessOrder.HOST = HOST;
    }
}
