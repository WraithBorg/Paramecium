package com.zxu.service;

import com.alibaba.fastjson.JSON;
import com.zxu.consts.SprKafkaConst;
import com.zxu.dto.OrderBill4kfk;
import com.zxu.dto.SpushNoticeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class KafkaProviderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProviderService.class);
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void send4NoticeMessage (SpushNoticeDto o) {
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(SprKafkaConst.topic4UserNotice, o);
        future.addCallback(result -> LOGGER.info("发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition()),
                ex -> LOGGER.error("发送消失败，原因：{}", ex.getMessage()));
    }

    public void send4OrderBill ( OrderBill4kfk orderBill) {
        int partion = Math.abs(orderBill.getBillNo().hashCode())%4;
        LOGGER.info("推送消息:partition:{}",partion);
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(SprKafkaConst.topic4OrderBill,partion,"KEY-"+ UUID.randomUUID().toString(), JSON.toJSONString(orderBill));
        
    }
}
