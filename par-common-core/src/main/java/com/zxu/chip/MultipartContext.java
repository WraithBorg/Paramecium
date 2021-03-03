package com.zxu.chip;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class MultipartContext {

    public static String multipartLocation;
    public static String resourceLocation;

    @Value("${spring.servlet.multipart.location}")
    public void setMultipartLocation(String multipartLocation) {
        MultipartContext.multipartLocation = multipartLocation;
    }
    @Value("${spring.resources.static-locations}")
    public void setResourceLocation(String resourceLocation) {
        MultipartContext.resourceLocation = resourceLocation.replace("file:","");
    }
}
