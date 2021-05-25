package com.zxu.client;

import com.alibaba.fastjson.JSON;
import com.zxu.constant.Hosts4Access;
import com.zxu.constant.Uri4Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class OrderClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderClient.class);
    @Resource
    private RestTemplate restTemplate;

    public void create() {
        String url = Hosts4Access.orderHosts + Uri4Order.GET;
        try {
            ResponseEntity<Map> forEntity = restTemplate.getForEntity(url, Map.class);
            Map body = forEntity.getBody();
            LOGGER.info("获取账户信息：{}", JSON.toJSON(body));
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }


}
