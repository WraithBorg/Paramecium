package com.zxu;

import com.zxu.dto.SpushNoticeExtend;

public class Test {
    public static void main (String[] args) {
        SpushNoticeExtend noticeExtend = new SpushNoticeExtend();
        noticeExtend.title("这是主标题");
        noticeExtend.subtitle("这是副标题");
        noticeExtend.bottom("这是底部");
        
        noticeExtend.mainlistAdd("订单编号","NO001");
        noticeExtend.mainlistAdd("消费金额","999");
        noticeExtend.mainlistAdd("下单时间","2021-01-01 12:12:11");
        System.out.println(noticeExtend.getJson());
    }
}
