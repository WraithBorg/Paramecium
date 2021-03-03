package com.zxu.security;

import com.zxu.common.domain.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public class JwtUtil {
	//生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。
	// 它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
	private static final KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
	//
	private static final String JWT_USER_ID = "USER_ID";
	private static final String JWT_TELEPHONE = "telePhone";
	private static final String JWT_PASSWORD = "password";

	/**
	 * 用户登录成功后生成Jwt
	 */
	public static String createJWT(long ttlMillis, UserInfo user) {
		//指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
		//生成JWT的时间
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		//创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(JWT_USER_ID, user.getId());
		claims.put(JWT_TELEPHONE, user.getTelePhone());
		claims.put(JWT_PASSWORD, user.getPassword());

		//生成签发人
		String subject = user.getNickName();
		//下面就是在为payload添加各种标准声明和私有声明了
		//这里其实就是new一个JwtBuilder，设置jwt的body
		JwtBuilder builder = Jwts.builder()
				//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
				.setClaims(claims)
				//设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
				.setId(UUID.randomUUID().toString())
				//iat: jwt的签发时间
				.setIssuedAt(now)
				//代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
				.setSubject(subject)
				//设置签名使用的签名算法和签名使用的秘钥
				.signWith( keyPair.getPrivate());
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			//设置过期时间
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	public static UserInfo parseUser(String token){
		UserInfo info = new UserInfo();
		Long second = 3 * 60L;
		Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(keyPair.getPublic()).setAllowedClockSkewSeconds(second).build().parseClaimsJws(token);
		Claims body = claimsJws.getBody();
		info.setTelePhone(String.valueOf(body.get(JWT_TELEPHONE)));
		return info;
	}
	/**
	 * 校验Token
	 */
	public static Boolean isVerify(String token, UserInfo user) {
		Long second = 3 * 60L;
		Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(keyPair.getPublic()).setAllowedClockSkewSeconds(second).build().parseClaimsJws(token);
		Claims body = claimsJws.getBody();
		if (body.get(JWT_PASSWORD).equals(user.getPassword())
				&& body.get(JWT_TELEPHONE).equals(user.getTelePhone())) {
			return true;
		}
		return false;
	}

}
