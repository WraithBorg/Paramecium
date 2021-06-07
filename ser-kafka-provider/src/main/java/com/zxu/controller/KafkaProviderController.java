package com.zxu.controller;

import com.zxu.dto.OrderBill4kfk;
import com.zxu.dto.SpushNoticeDto;
import com.zxu.service.KafkaProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class KafkaProviderController {
    @Resource
    private KafkaProviderService producer;

    /**
     * 发送消息通知
     * localhost:8090/kafkaPrivoder/noticeMessage
     * {"id":"84d8f00a-e999-4de6-b58c-d3cb8931cb37","title":{"color":"#000000","text":"这是主标题"},"subtitle":{"color":"#999999","text":"这是副标题"},"bottom":{"color":"#000aaa","text":"这是底部"},"mainlist":[{"left":{"color":"#999999","text":"订单编号"},"right":{"color":"#384D92","text":"NO001"}},{"left":{"color":"#999999","text":"消费金额"},"right":{"color":"#384D92","text":"999"}},{"left":{"color":"#999999","text":"下单时间"},"right":{"color":"#384D92","text":"2021-01-01 12:12:11"}}]}
     */
    @PostMapping(value = "/noticeMessage")
    @ResponseBody
    public void noticeMessage (@RequestBody SpushNoticeDto noticeDto) {
        this.producer.send4NoticeMessage(noticeDto);
    }

    /**
     * 推送订单信息
     */
    @PostMapping(value = "/pushOrderBill")
    @ResponseBody
    public void pushOrderBill (@RequestBody OrderBill4kfk orderBill) {
        this.producer.send4OrderBill(orderBill);
    }

}
