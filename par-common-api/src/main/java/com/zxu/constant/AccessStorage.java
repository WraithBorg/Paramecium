package com.zxu.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 访问接口常量
 */
@Component
@PropertySource("classpath:access-storage.properties")
public class AccessStorage {
    public static final String QUERY_INVENTORY = "queryInventory";
    public static final String PLUS_INVENTORY = "plusInventory";
    public static final String MINUS_INVENTORY = "minusInventory";
    public static String HOST;

    @Value("${storage.host}")
    public void setHOST(String HOST) {
        AccessStorage.HOST = HOST;
    }
}
