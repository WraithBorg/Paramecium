package com.zxu.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxu.dto.SpushNoticeDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SpushNoticeService {
    private final Logger LOGGER = LoggerFactory.getLogger(SpushNoticeService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = {"topic4UserNotice"}, groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> orderBillRecord) {
        try {
            SpushNoticeDto noticeDto = objectMapper.readValue(orderBillRecord.value(), SpushNoticeDto.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息 -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
