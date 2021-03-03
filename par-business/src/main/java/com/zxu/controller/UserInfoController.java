package com.zxu.controller;

import com.zxu.util.SessionUtil;
import com.zxu.common.domain.UserInfo;
import com.zxu.constant.PageConst;
import com.zxu.convert.UserInfoConvert;
import com.zxu.dto.ModifyPassDTO;
import com.zxu.dto.PayPwdDTO;
import com.zxu.dto.UserInfoDTO;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CustomUtils;
import com.zxu.vo.UserInfoVO;
import com.zxu.vo.UserPassVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Map;

/**
 * 用户信息
 */
@RestController
public class UserInfoController {
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserInfoConvert userInfoConvert;


    /**
     * @Range 用户设置
     */
    @RequestMapping("/user/set")
    public MsgResult set() {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        UserInfoVO userInfoVO = userInfoConvert.getUserVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userInfoVO);
        return MsgResult.doneUrl(data, PageConst.USER_SET_SHOW);
    }

    /**
     * 获取用户资料
     *
     * @Range 修改用户资料
     */
    @RequestMapping("/user/info")
    public MsgResult info() {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        UserInfoVO userInfoVO = userInfoConvert.getUserVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userInfoVO);
        return MsgResult.doneUrl(data, PageConst.USER_INFO_SHOW);
    }

    /**
     * 修改用户资料
     */
    @PostMapping("/user/save")
    public MsgResult save(UserInfoDTO userInfoDTO) {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        defaultUser.setNickName(userInfoDTO.getNickname());
        userInfoMapper.updateById(defaultUser);
        return MsgResult.doneUrl(new ArrayList<>(), PageConst.USER_INFO_SHOW);
    }

    /**
     * 获取用户资料
     *
     * @Range 获取用户头像
     */
    @GetMapping("/user/user_head")
    public MsgResult user_head() {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        UserPassVO userPassVO = userInfoConvert.getUserPassVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userPassVO);
        return MsgResult.doneUrl(data, PageConst.USER_PWD_SHOW);
    }


    /**
     * 获取用户资料
     *
     * @Range 修改密码
     */
    @GetMapping("/user/password")
    public MsgResult password() {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        UserPassVO userPassVO = userInfoConvert.getUserPassVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userPassVO);
        return MsgResult.doneUrl(data, PageConst.USER_PWD_SHOW);
    }

    /**
     * 修改密码
     */
    @PostMapping("/user/passwordsave")
    public MsgResult passwordsave(ModifyPassDTO modifyPassDTO) {
        // validate
        if (!modifyPassDTO.getPassword().equals(modifyPassDTO.getPassword2())) {
            return MsgResult.fail("新密码输入不一致");
        }
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        if (!defaultUser.getPassword().equals(modifyPassDTO.getOldpassword())) {
            return MsgResult.fail("旧密码出错");
        }
        // save
        defaultUser.setPassword(modifyPassDTO.getPassword());
        userInfoMapper.updateById(defaultUser);
        UserPassVO userPassVO = userInfoConvert.getUserPassVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userPassVO);
        return MsgResult.doneUrl(data, PageConst.USER_PWD_SHOW);
    }

    /**
     * 获取用户资料
     *
     * @Range 支付密码
     */
    @GetMapping("/user/paypwd")
    public MsgResult paypwd() {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        UserPassVO userPassVO = userInfoConvert.getUserPassVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userPassVO);
        return MsgResult.doneUrl(data, PageConst.USER_PAY_PWD_SHOW);
    }

    /**
     * 获取修改支付密码
     */
    @PostMapping("/user/savepaypwd")
    public MsgResult savePayPwd(PayPwdDTO payPwdDTO) {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        if (!defaultUser.getPassword().equals(payPwdDTO.getPassword())) {
            return MsgResult.fail("登录密码出错");
        }
        defaultUser.setPayPwd(payPwdDTO.getPaypwd());
        userInfoMapper.updateById(defaultUser);
        return MsgResult.doneUrl(new ArrayList<>(), PageConst.USER_PAY_PWD_SHOW);
    }
}
