package com.zxu.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.zxu.dto.OrderBill4kfk;
import com.zxu.dto.SpushNoticeDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class NoticeMessageService {
    private final Logger LOGGER = LoggerFactory.getLogger(NoticeMessageService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topicPartitions = {@TopicPartition(topic = SprKafkaConst.topic4UserNotice,partitions = {"0"})},groupId = "group1")
    public void consumeMessage(ConsumerRecord<String, String> orderBillRecord) {
        try {
            SpushNoticeDto noticeDto = objectMapper.readValue(orderBillRecord.value(), SpushNoticeDto.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息,group:{} -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString(),"group1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @KafkaListener(topicPartitions = {@TopicPartition(topic = SprKafkaConst.topic4OrderBill,partitions = {"0"})},groupId = "group1")
    public void topic4OrderBill4Zero(ConsumerRecord<String, String> orderBillRecord) {
        try {
            OrderBill4kfk noticeDto = objectMapper.readValue(orderBillRecord.value(), OrderBill4kfk.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息,group:{} -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString(),"group1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @KafkaListener(topicPartitions = {@TopicPartition(topic = SprKafkaConst.topic4OrderBill,partitions = {"1"})},groupId = "group1")
    public void topic4OrderBill4One(ConsumerRecord<String, String> orderBillRecord) {
        try {
            OrderBill4kfk noticeDto = objectMapper.readValue(orderBillRecord.value(), OrderBill4kfk.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息,group:{} -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString(),"group1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @KafkaListener(topicPartitions = {@TopicPartition(topic = SprKafkaConst.topic4OrderBill,partitions = {"2"})},groupId = "group1")
    public void topic4OrderBill4Two(ConsumerRecord<String, String> orderBillRecord) {
        try {
            OrderBill4kfk noticeDto = objectMapper.readValue(orderBillRecord.value(), OrderBill4kfk.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息,group:{} -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString(),"group1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @KafkaListener(topicPartitions = {@TopicPartition(topic = SprKafkaConst.topic4OrderBill,partitions = {"3"})},groupId = "group1")
    public void topic4OrderBill4Three(ConsumerRecord<String, String> orderBillRecord) {
        try {
            OrderBill4kfk noticeDto = objectMapper.readValue(orderBillRecord.value(), OrderBill4kfk.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息,group:{} -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString(),"group1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @KafkaListener(topicPartitions = {@TopicPartition(topic = SprKafkaConst.topic4OrderBill,partitions = {"3"})},groupId = "group2")
    public void topic4OrderBill4Three4Group2(ConsumerRecord<String, String> orderBillRecord) {
        try {
            OrderBill4kfk noticeDto = objectMapper.readValue(orderBillRecord.value(), OrderBill4kfk.class);
            LOGGER.info("消费者消费topic:{} partition:{}的消息,group:{} -> {}", orderBillRecord.topic(), orderBillRecord.partition(), noticeDto.toString(),"group2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
