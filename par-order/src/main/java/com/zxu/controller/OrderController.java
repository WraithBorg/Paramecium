package com.zxu.controller;

import com.zxu.constant.Uri4Order;
import com.zxu.util.CustomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class OrderController {
    @ResponseBody
    @RequestMapping(Uri4Order.GET)
    public Map getAccountInfo(){
        return CustomUtils.ofMap("name", "OrderController");
    }
}
