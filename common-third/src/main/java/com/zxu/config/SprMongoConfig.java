package com.zxu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mongo.properties")
public class SprMongoConfig {
    
}
