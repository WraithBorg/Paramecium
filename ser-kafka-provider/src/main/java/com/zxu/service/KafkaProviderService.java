package com.zxu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

@Service
public class KafkaProviderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProviderService.class);
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage (String topic, Object o) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, o);
        future.addCallback(result -> LOGGER.info("生产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> LOGGER.error("生产者发送消失败，原因：{}", ex.getMessage()));
    }

}
