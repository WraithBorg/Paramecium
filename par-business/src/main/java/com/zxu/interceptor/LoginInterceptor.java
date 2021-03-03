package com.zxu.interceptor;

import com.alibaba.fastjson.JSON;
import com.zxu.annotate.WithoutLogin;
import com.zxu.domain.UserInfo;
import com.zxu.constant.ErrCodeConst;
import com.zxu.constant.SessionConst;
import com.zxu.mapper.UserInfoMapper;
import com.zxu.result.MsgResult;
import com.zxu.security.JwtDTO;
import com.zxu.security.JwtUtil;
import com.zxu.service.usb.UserInfoService;
import com.zxu.util.CustomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private static final String LI_AUTH_CODE = "authcode";
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authCode = request.getParameter(LI_AUTH_CODE);
        if (CustomUtils.isBlank(authCode)) {
            return true;
        }
        try {
            userInfoMapper.selectList(null);
            UserInfo userDB = userInfoService.getUserByTelephone(JwtUtil.parseUser(authCode).getTelePhone());
            if (userDB == null) {
                logger.error("用户账户不存在" + ErrCodeConst.A0201);
                return false;
            }
            JwtDTO jwtDTO = JwtDTO.builder(userDB.getId(), userDB.getNickName(), userDB.getPassword(), userDB.getTelePhone());
            JwtUtil.isVerify(authCode, jwtDTO);
            request.getSession().setAttribute(SessionConst.CURRENT_USER, userDB);
            return true;
        } catch (io.jsonwebtoken.security.SignatureException e) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            WithoutLogin withoutLogin = handlerMethod.getMethodAnnotation(WithoutLogin.class);
            if (withoutLogin != null) {
                return true;
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            logger.error("登录信息失效，请重新登录！" + ErrCodeConst.A0210, e.getMessage());
            String toJSON = JSON.toJSONString(MsgResult.fail("登录信息失效，请重新登录！" + ErrCodeConst.A0210));
            PrintWriter out = response.getWriter();
            out.append(toJSON);
            return false;
        } catch (Exception e) {
            logger.error("登录信息异常！" + ErrCodeConst.A0210, e);
            return false;
        }


    }
}
