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
 * 消息通知
 */
@RestController
public class NoticeInfoController {
    @Resource
    private HttpServletRequest httpServletRequest;
    /**
     * 我的消息
     */
    @GetMapping("/notice/mynotice")
    public MsgResult mynotice() {
        Map data = CCommonUtils.ofMap("data", new ArrayList<>(), "pagelist", false, "rscount", 0);
        return MsgResult.doneUrl(data, PageConst.MY_NOTICE);
    }
}
