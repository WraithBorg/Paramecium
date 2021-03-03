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
    public static final String GET = "get";
    public static String HOST;

    @Value("${storage.host}")
    public void setHOST(String HOST) {
        AccessStorage.HOST = HOST;
    }
}
