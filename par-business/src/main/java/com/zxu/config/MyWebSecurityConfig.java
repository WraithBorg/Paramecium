package com.zxu.config;//package com.io.hydralisk.config;
//
//import org.apache.catalina.filters.CorsFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/**");
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors(Customizer.withDefaults());
////        http.authorizeRequests().antMatchers("/**").permitAll();
////        http
////                .authorizeRequests().antMatchers("/**")
////                .permitAll()
////                .anyRequest()
////                .authenticated()
////        .and().formLogin().loginProcessingUrl("/login/loginsave").permitAll();
////    }
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("*");//放行哪些域
//        configuration.setAllowCredentials(true);//是否发送cookie信息
//        configuration.addAllowedMethod("*");//放行哪些原始域（请求方式）
//        configuration.addAllowedHeader("*");//放行哪些原始域（头部信息）
//        configuration.addExposedHeader("Content-Type");
//        configuration.addExposedHeader("X-Requested-With");
//        configuration.addExposedHeader("accept");
//        configuration.addExposedHeader("Origin");
//        configuration.addExposedHeader("Access-Control-Request-Method");
//        configuration.addExposedHeader("Access-Control-Request-Headers");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//}
