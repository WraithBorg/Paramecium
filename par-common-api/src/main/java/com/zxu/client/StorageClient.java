package com.zxu.client;

import com.alibaba.fastjson.JSON;
import com.zxu.constant.AccessAccount;
import com.zxu.constant.AccessStorage;
import com.zxu.result.DockResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class StorageClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(StorageClient.class);
    @Resource
    private RestTemplate restTemplate;

  
    /**
     * 查询库存数
     */
    public DockResult queryInventory(String json) {
        String url = AccessStorage.HOST + AccessStorage.QUERY_INVENTORY;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<DockResult> forEntity = restTemplate.postForEntity(url, request, DockResult.class);
            DockResult body = forEntity.getBody();
            LOGGER.info("查询库存数：{}", JSON.toJSON(body));
            return body;
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }

    /**
     * 加库存
     */
    public DockResult plusInventory(String json) {
        String url = AccessStorage.HOST + AccessStorage.PLUS_INVENTORY;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<DockResult> forEntity = restTemplate.postForEntity(url, request, DockResult.class);
            DockResult body = forEntity.getBody();
            LOGGER.info("加库存：{}", JSON.toJSON(body));
            return body;
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }

    /**
     * 减库存
     */
    public DockResult minusInventory(String json) {
        String url = AccessStorage.HOST + AccessStorage.MINUS_INVENTORY;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<DockResult> forEntity = restTemplate.postForEntity(url, request, DockResult.class);
            DockResult body = forEntity.getBody();
            LOGGER.info("减库存：{}", JSON.toJSON(body));
            return body;
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }
}
