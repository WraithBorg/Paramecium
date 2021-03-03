package com.zxu.controller;

import com.zxu.annotate.WithoutLogin;
import com.zxu.common.domain.UserInfo;
import com.zxu.dto.RegisterDTO;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.util.CCommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户注册
 */
@RequestMapping("/register")
@RestController
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 获取验证码
     */
    @WithoutLogin
    @CrossOrigin(origins = "*")
    @GetMapping(params = "m=SendSms")
    public void SendSms(@RequestParam(required = false) String telephone) {
        // 发送验证码 TODO
        logger.info("获取验证码。");
    }

    /**
     * 用戶註冊
     */
    @WithoutLogin
    @PostMapping(params = "m=regsave")
    public Object regsave(RegisterDTO registerDTO) {
        logger.info("用戶註冊註冊註冊。注册");
        // validate
        if (CCommonUtils.isBlank(registerDTO.getNickname())) {
            return CCommonUtils.ofMap("error", 1, "message", "请填写昵称");
        }
        if (CCommonUtils.isBlank(registerDTO.getTelephone())) {
            return CCommonUtils.ofMap("error", 1, "message", "请填写手机号");
        }
        if (CCommonUtils.isBlank(registerDTO.getPassword())) {
            return CCommonUtils.ofMap("error", 1, "message", "请填写密码");
        }

        List<UserInfo> v_telePhone = userInfoMapper.selectByMap(CCommonUtils.ofMap(UserInfo.t.telephone, registerDTO.getTelephone()));
        if (v_telePhone.size() > 0) {
            return CCommonUtils.ofMap("error", 1, "message", "该手机号已注册");
        }
        List<UserInfo> v_nickName = userInfoMapper.selectByMap(CCommonUtils.ofMap(UserInfo.t.nickname, registerDTO.getNickname()));
        if (v_nickName.size() > 0) {
            return CCommonUtils.ofMap("error", 1, "message", "该昵称已注册");
        }

        // install
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(registerDTO.getNickname());
        userInfo.setTelePhone(registerDTO.getTelephone());
        userInfo.setPassword(registerDTO.getPassword());
        // save
        int insert = userInfoMapper.insert(userInfo);
        if (insert > 0) {
            Map data = CCommonUtils.ofMap("authcode", "zxcvb21345");
            return CCommonUtils.ofMap("error", 0, "data", data);
        } else {
            return CCommonUtils.ofMap("error", 1, "message", "注册失败");
        }
    }
}
