package com.zxu.controller;

import com.zxu.constant.PageConst;
import com.zxu.result.MsgResult;
import com.zxu.util.CCommonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * 充值记录
 */
@RestController
public class RechargeController {
    @Resource
    private HttpServletRequest httpServletRequest;
    /**
     * 查询充值记录
     */
    @GetMapping("/recharge/myrecharge")
    public MsgResult myRecharge() {
        Map data = CCommonUtils.ofMap("data", new ArrayList<>(), "pagelist", false, "rscount", 0, "per_page", 0);
        return MsgResult.doneUrl(data, PageConst.RECHARGE_LOG);
    }
//    dateline: 1594169134
//    id: 127
//    money: "1000.00"
//    openid: ""
//    orderdata: "eyJ0YWJsZSI6InBsdWdpbiIsImNhbGxiYWNrIjoiXG5cdFx0XHRcdE1NKFwiYjJjXCIsXCJiMmNfb3JkZXJcIiktPnVwZGF0ZShhcnJheShcblx0XHRcdFx0XHRcImlzcGF5XCI9PjEsXG5cdFx0XHRcdFx0XCJyZWNoYXJnZV9pZFwiPT5cIiRyZWNoYXJnZV9pZFwiLFxuXHRcdFx0XHRcdFwicGF5dHlwZVwiPT5cIlwiLFxuXHRcdFx0XHQpLFwib3JkZXJpZD0xMDdcIik7XG5cdFx0XHRcdE1NKFwiYjJjXCIsXCJiMmNfb3JkZXJcIiktPnBpbk9yZGVyKDEwNyk7XG5cdFx0XHQiLCJ1cmwiOiJodHRwczpcL1wva2ZiYy5kZWl0dWkuY29tXC91bmlhcHBcL2g1XC8jXC9wYWdlc1wvYjJjX29yZGVyXC9zdWNjZXNzIn0="
//    orderinfo: "2020-07-08 08:45:34购买商品"
//    orderno: "Re232"
//    pay_orderno: ""
//    pay_type: "alipay"
//    siteid: 1
//    status: 2
//    status_name: "失败"
//    tablename: ""
//    timeago: "6小时前"
//    type_id: 1
//    userid: 136
}

