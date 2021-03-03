package com.zxu.client;

import com.alibaba.fastjson.JSON;
import com.zxu.constant.AccessAccount;
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

@Component
public class AccountClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountClient.class);
    @Resource
    private RestTemplate restTemplate;

    /**
     * 查询余额
     */
    public DockResult getAccount(String json) {
        String url = AccessAccount.HOST + AccessAccount.GET_INFO;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<DockResult> forEntity = restTemplate.postForEntity(url, request, DockResult.class);
            DockResult body = forEntity.getBody();
            LOGGER.info("获取账户信息：{}", JSON.toJSON(body));
            return body;
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }

    /**
     * 扣款
     */
    public DockResult deduct(String json) {
        String url = AccessAccount.HOST + AccessAccount.DEDUCT;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<DockResult> forEntity = restTemplate.postForEntity(url, request, DockResult.class);
            DockResult body = forEntity.getBody();
            LOGGER.info("扣款：{}", JSON.toJSON(body));
            return body;
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }

    /**
     * 充值
     */
    public DockResult charge(String json) {
        String url = AccessAccount.HOST + AccessAccount.CHARGE;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(json, headers);
            ResponseEntity<DockResult> forEntity = restTemplate.postForEntity(url, request, DockResult.class);
            DockResult body = forEntity.getBody();
            LOGGER.info("充值：{}", JSON.toJSON(body));
            return body;
        } catch (Exception e) {
            LOGGER.error("create url {} ,error:", url, e);
            throw new RuntimeException();
        }
    }
}
