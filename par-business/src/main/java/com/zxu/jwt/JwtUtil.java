package com.zxu.jwt;//package com.io.hydralisk.jwt;
//
//
//import com.alibaba.fastjson.JSON;
//import com.fasterxml.jackson.annotation.JsonAlias;
//import io.jsonwebtoken.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
//
//public class JwtUtil {
//	private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);
//	private static final String JWT_SECRET = "TIbT7O98bUc";
//	public static final String JWT_TOKEN = "jwtToken";
//	public static final String LOGIN_FLAG = "loginFlag";
//	public static final String JWT_INFO = "jwtInfo";
//	public static final String JWT_USER_ID = "userId";
//	public static final String JWT_PWD = "dwp";
//	public static final String JWT_VERSION = "version";
//	public static final String JWT_SUFFIX = "jwt_user_id";
//
//
//	private static final JSON GSON = new JSON();
//
//	private JwtUtil() {
//	}
//
//	private static class JwtAppHolder {
//		private static JwtUtil instance = new JwtUtil();
//	}
//
//	public static JwtUtil instance() {
//		return JwtAppHolder.instance;
//	}
//
//
//	/**
//	 * 默认生效时间 1 h
//	 */
//	private static final Long DEFAULT_EXPIRE_TIME = (long) 1000 * 60 * 60;
//
//	/**
//	 * 创建jwt
//	 *
//	 * @author zxu
//	 * @time 2019/12/17 19:16
//	 */
//	public String createJWT(String uId, JwtInfo jwtInfo) {
//		return createJWT(uId, jwtInfo, DEFAULT_EXPIRE_TIME);
//	}
//
//	/**
//	 * 创建jwt
//	 *
//	 * @author zxu
//	 * @time 2019/12/17 19:16
//	 */
//	public String createJWT(String uId, JwtInfo jwtInfo, long ttlMillis) {
//
//		String subject = GSON.toJson(jwtInfo);
//		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//		long nowMillis = System.currentTimeMillis();
//		Date now = new Date(nowMillis);
//		Map<String, Object> claims = new HashMap<>(8);
//
//		claims.put("uId", uId);
//
//		SecretKey key = generalKey();
//		JwtBuilder builder = Jwts.builder()
//				.setClaims(claims)
//				.setId(UUID.randomUUID().toString())
//				.setIssuedAt(now)
//				.setSubject(subject)
//				.signWith(signatureAlgorithm, key);
//		if (ttlMillis >= 0) {
//			long expMillis = nowMillis + ttlMillis;
//			Date exp = new Date(expMillis);
//			builder.setExpiration(exp);
//		}
//		return builder.compact();
//	}
//
//	/**
//	 * 解密jwt
//	 *
//	 * @author zxu
//	 * @time 2019/12/17 19:16
//	 */
//	public Claims parseJWT(String jwt) {
//		SecretKey key = generalKey();
//		Claims claims = Jwts.parser()
//				.setSigningKey(key)
//				.parseClaimsJws(jwt).getBody();
//		return claims;
//	}
//
//	/**
//	 * 由字符串生成加密key
//	 *
//	 * @author zxu
//	 * @time 2019/12/17 19:16
//	 */
//	public static SecretKey generalKey() {
//		String stringKey = JWT_SECRET;
//		byte[] encodedKey = Base64.decodeBase64(stringKey);
//		//	Base64.encodeBase64URLSafeString(encodedKey)
//		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//		return key;
//	}
//
//	/**
//	 * 校验token
//	 */
//	public static Map<String, Object> verify(String loginFlag) {
//		try {
//			JwtInfo jwtInfo = GSON.fromJson(instance().parseJWT(loginFlag).getSubject(), JwtInfo.class);
//			return Maps.create(JWT_INFO, jwtInfo, LOGIN_FLAG, loginFlag);
//		} catch (SignatureException e) {
//			logger.error("校验token错误：", e);
//			throw new BusinessException("token错误");
//		} catch (ExpiredJwtException e) {
//			throw new BusinessException("请重新登录");
//		}
//	}
//
//	public static void main(String[] args) {
//
//		String jwtToken = JwtUtil.instance().createJWT("1111", new JwtInfo("loginIIID", "zhangx", 111L), 5000);
//		JwtUtil.instance().parseJWT(jwtToken);
//		System.out.println(jwtToken);
//		jwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJ1SWQiOiIxMTExIiwic3ViIjoie1wibG9naW5JZFwiOlwibG9naW5JSUlEXCIsXCJsb2dpbk5hbWVcIjpcInpoYW5neFwiLFwidmVyc2lvblwiOjExMX0iLCJleHAiOjE1NzcxODA5MDAsImlhdCI6MTU3NzE4MDg0MCwianRpIjoiNDA1MWEyZDAtNzdjZS00OGZiLThmMTktOWFjMWM1MmM3N2IxIn0.2mJe1wums4ChzFhPpwpL11nzEYndQlSrkVCLqf2BaRs";
//
//
//		SecretKey key = generalKey();
//		Long times = Jwts.parser()
//				.setSigningKey(key)
//				.parseClaimsJws(jwtToken).getBody().getExpiration().getTime();
//		System.out.println(times);
//	}
//}
