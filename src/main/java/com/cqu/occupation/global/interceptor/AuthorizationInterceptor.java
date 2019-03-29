package com.cqu.occupation.global.interceptor;

import com.cqu.occupation.common.vo.ResultVO;
import com.cqu.occupation.global.annotation.AuthorityRequired;
import com.cqu.occupation.global.constants.Constants;
import com.cqu.occupation.global.constants.UserType;
import com.cqu.occupation.global.exception.exceptions.code.ExceptionCode;
import com.cqu.occupation.global.jwt.JwtUtils;
import com.cqu.occupation.user.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author sukaiyi
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    ObjectMapper mapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        AuthorityRequired authorityRequired = method.getAnnotation(AuthorityRequired.class);
        if (authorityRequired == null) {
            return true;
        }
        UserType[] allowedTypes = authorityRequired.allow();
        if (allowedTypes.length == 1 && allowedTypes[0] == UserType.TOURIST) {
            return true;
        }
        String token = request.getHeader(Constants.TOKEN_FIELD);
        User user = JwtUtils.verifyToken(token);

        if (Arrays.stream(allowedTypes).map(UserType::getCode).collect(Collectors.toList()).contains(user.getType())) {
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            ResultVO result = ResultVO.error(
                    ExceptionCode.AUTHORIZATION_FAILED,
                    "无权限访问该资源");
            try (PrintWriter out = response.getWriter()) {
                out.write(mapper.writeValueAsString(result));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
