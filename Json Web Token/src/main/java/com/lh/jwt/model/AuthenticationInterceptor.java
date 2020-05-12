package com.lh.jwt.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @ClassName: AuthenticationInterceptor
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 15:20
 * @Version: 1.0
 **/
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从http请求头中取出token
        final String token = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);
        //如果不是映射到方法，直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //如果是方法探测，直接通过
        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        //如果方法有JwtIgnore注解，直接通过
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        if (method.isAnnotationPresent(JwtIgnore.class)) {
            JwtIgnore jwtIgnore = method.getAnnotation(JwtIgnore.class);
            if(jwtIgnore.value()){
                return true;
            }
        }
//        LocalAssert.isStringEmpty(token, "token为空，鉴权失败！");
        if (StringUtils.isEmpty(token)){
            throw new Exception("token为空，鉴权失败！");
        }
        //验证，并获取token内部信息
        String userToken = JwtTokenUtil.verifyToken(token);

        //将token放入本地缓存
        WebContextUtil.setUserToken(userToken);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //方法结束后，移除缓存的token
        WebContextUtil.removeUserToken();
    }
}
