package com.zxu.controller;

import com.zxu.security.JwtDTO;
import com.zxu.util.SessionUtil;
import com.zxu.annotate.WithoutLogin;
import com.zxu.domain.UserInfo;
import com.zxu.constant.PageConst;
import com.zxu.convert.UserInfoConvert;
import com.zxu.dto.LoginDTO;
import com.zxu.dto.RegisterDTO;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.security.JwtUtil;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CustomUtils;
import com.zxu.vo.UserInfoVO;
import com.zxu.vo.UserMenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 用户登录
 */
@RestController
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserInfoConvert userInfoConvert;
    /**
     * 用户登录
     */
    @WithoutLogin
    @PostMapping("/login/loginsave")
    public MsgResult loginsave(LoginDTO loginDTO) {
        // validate
        String telephone = loginDTO.getTelephone();
        List<UserInfo> v_telephone = userInfoMapper.selectByMap(CustomUtils.ofMap(UserInfo.t.telephone, telephone));
        if (v_telephone.size() == 0) {
            return MsgResult.fail("账号不存在");
        }
        UserInfo userInfo = v_telephone.get(0);
        if (!userInfo.getPassword().equals(loginDTO.getPassword())) {
            return MsgResult.fail("密码错误");
        }
        //
        JwtDTO dto = JwtDTO.builder(userInfo.getId(), userInfo.getNickName(), userInfo.getPassword(), userInfo.getTelePhone());
        String jwtToken = JwtUtil.createJWT(1000 * 60, dto);
        Map<String, String> data = CustomUtils.ofMap(
                "authcode", jwtToken,
                "authcodeLong", jwtToken,
                "backurl", "\\/index.php");
        return MsgResult.doneUrl(data, PageConst.INDEX_PAGE,"登录成功");

    }

    /**
     * 修改密码 获取短信验证码
     */
    @GetMapping("login/sendsms")
    public MsgResult sendsms(String telephone) {
        return MsgResult.doneMsg("获取短信验证码成功");
    }

    /**
     * 修改密码
     */
    @PostMapping("login/findpwdSave")
    public MsgResult findpwdSave(RegisterDTO registerDTO) {
        return MsgResult.doneUrl("密码修改成功，马上登录", PageConst.INDEX_LOGIN);
    }


    /**
     * 登录后获取用户信息
     */
    @GetMapping("logined/b2c_user")
    public MsgResult b2c_user() {
        UserInfo defaultUser = SessionUtil.getCurrentUser(httpServletRequest);
        if (defaultUser == null){
            return MsgResult.fail("未登录");
        }
        UserInfoVO userInfoVO = userInfoConvert.getUserVO(defaultUser);
        Map data = CustomUtils.ofMap("data", userInfoVO, "navList", UserMenuVO.getNavList());
        return MsgResult.doneUrl(data,PageConst.USER_INDEX);
    }


    /**
     * 退出登录
     */
    @GetMapping("login/logout")
    public MsgResult logout() {
        return MsgResult.done();
    }
}
