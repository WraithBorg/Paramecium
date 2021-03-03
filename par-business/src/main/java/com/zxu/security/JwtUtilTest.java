package com.zxu.security;

import com.zxu.common.domain.UserInfo;
import com.zxu.util.CCommonUtils;

import java.util.Map;

public class JwtUtilTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("zx012");
        userInfo.setNickName("张三");
        userInfo.setPassword("0000");
        userInfo.setTelePhone("110");
        // 1000 * 60
        String jwtToken = JwtUtil.createJWT(10, userInfo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, String> userMap = CCommonUtils.ofMap("jwtToken", jwtToken);
        boolean fa = verifyToken(jwtToken);
        System.out.println(fa);
    }

    private static boolean verifyToken(String jwtToken) {
        UserInfo userInfoDB = new UserInfo();
        userInfoDB.setId("zx01");
        userInfoDB.setNickName("张三");
        userInfoDB.setPassword("0000");
        userInfoDB.setTelePhone("110");
        Boolean verify = JwtUtil.isVerify(jwtToken, userInfoDB);
        return verify;
    }
}
