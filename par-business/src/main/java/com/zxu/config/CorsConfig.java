package com.zxu.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域全局解决方案
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1.添加CORS配置信息
        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*");//放行哪些域
        configuration.addAllowedOriginPattern("*");//放行哪些域
        configuration.setAllowCredentials(true);//是否发送cookie信息
        configuration.addAllowedMethod("*");//放行哪些原始域（请求方式）
        configuration.addAllowedHeader("*");//放行哪些原始域（头部信息）
//        configuration.addExposedHeader("*");//暴露哪些头部信息（因为跨域访问不能暴露全部头部信息）
        configuration.addExposedHeader("Content-Type");
        configuration.addExposedHeader("X-Requested-With");
        configuration.addExposedHeader("accept");
        configuration.addExposedHeader("Origin");
        configuration.addExposedHeader("Access-Control-Request-Method");
        configuration.addExposedHeader("Access-Control-Request-Headers");
        // 2. 添加映射路径
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);
        // 3. 返回新的CorsFilter
        return new CorsFilter(configurationSource);


    }
}
