package com.zxu.config;

import com.zxu.consts.SprKafkaConst;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SprTopic {
    @Bean
    public NewTopic topic4UserNotice () {
        return new NewTopic(SprKafkaConst.topic4UserNotice, SprKafkaConst.topic4UserNotice_partition, (short) 1);
    }

    @Bean
    public NewTopic topic4OrderBill () {
        return new NewTopic(SprKafkaConst.topic4OrderBill, SprKafkaConst.topic4OrderBill_partition, (short) 1);
    }
}
