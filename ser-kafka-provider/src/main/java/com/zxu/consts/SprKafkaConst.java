package com.zxu.consts;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka.topic", ignoreInvalidFields = true, ignoreUnknownFields = true)
public class SprKafkaConst {
    public static String topic4UserNotice;
    public static String topic4Test;

    public String getTopic4UserNotice () {
        return topic4UserNotice;
    }

    public void setTopic4UserNotice (String topic4UserNotice) {
        this.topic4UserNotice = topic4UserNotice;
    }

    public String getTopic4Test () {
        return topic4Test;
    }

    public void setTopic4Test (String topic4Test) {
        this.topic4Test = topic4Test;
    }
}
