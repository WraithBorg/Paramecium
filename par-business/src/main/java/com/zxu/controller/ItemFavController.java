package com.zxu.controller;

import com.zxu.util.SessionUtil;
import com.zxu.common.domain.UserInfo;
import com.zxu.constant.PageConst;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.UserFavItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 收藏商品
 */
@RestController
public class ItemFavController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private UserFavItemService userFavInfoService;
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 收藏商品
     */
    @RequestMapping("/item/itemfav")
    public MsgResult toggle(String objectid) {
        UserInfo currentUser = SessionUtil.getCurrentUser(httpServletRequest);
        String method = userFavInfoService.favItem(currentUser.getId(), objectid);
        return MsgResult.doneUrl(method, PageConst.PRODUCT_SHOW + objectid);
    }


}
