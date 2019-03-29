package com.cqu.occupation.global.jwt;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cqu.occupation.global.constants.UserType;
import com.cqu.occupation.user.entity.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sukaiyi
 * @date 2019/3/28
 */
public class JwtUtils {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256("cqu-occupation-what-is-this");
    private static final String ISSUER = "cqu-occupation";

    public static User verifyToken(String token) {
        User user = new User();
        user.setType(UserType.TOURIST.getCode());
        try {
            JWTVerifier verifier = JWT.require(ALGORITHM).withIssuer(ISSUER).build();
            DecodedJWT jwt = verifier.verify(token);
            user.setUsername(jwt.getClaim("username").as(String.class));
            user.setType(jwt.getClaim("type").as(Integer.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static String createToken(User user) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        Date nowDate = new Date();
        Date expiresDate = DateUtil.offsetHour(nowDate, 2);

        return JWT.create()
                .withHeader(map)
                .withIssuer(ISSUER)
                .withSubject("occupation")
                .withAudience("WEB")
                .withIssuedAt(nowDate)
                .withExpiresAt(expiresDate)
                .withClaim("username", user.getUsername())
                .withClaim("type", user.getType())
                .sign(ALGORITHM);
    }

}
