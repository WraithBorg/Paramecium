package com.zxu.security;

import com.zxu.util.CustomUtils;

import java.util.Map;

public class JwtUtilTest {
//    public static void main(String[] args) {
//        JwtDTO jwtDTO = JwtDTO.builder("zx012", "张三", "0000", "110");
//        // 1000 * 60
//        String jwtToken = JwtUtil.createJWT(10, jwtDTO);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Map<String, String> userMap = CustomUtils.ofMap("jwtToken", jwtToken);
//        boolean fa = verifyToken(jwtToken);
//        System.out.println(fa);
//    }

    private static boolean verifyToken(String jwtToken) {
        JwtDTO jwtDTO = JwtDTO.builder("zx012", "张三", "0000", "110");
        Boolean verify = JwtUtil.isVerify(jwtToken, jwtDTO);
        return verify;
    }
}
