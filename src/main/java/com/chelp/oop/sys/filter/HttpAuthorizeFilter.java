package com.chelp.oop.sys.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chelp.core.common.ResponseData;
import com.chelp.oop.common.BusinessCodeEnum;
import com.chelp.oop.utils.JwtUtil.JwtHelper;
import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt 认证 filter
 */
public class HttpAuthorizeFilter implements  Filter{

    private String encoding;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        ResponseData resultMsg;
        request.setCharacterEncoding(encoding);
        HttpServletRequest request1= (HttpServletRequest) request;
        String contextPath =request1.getServletPath();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //过滤登录请求，有注册等不需要登录权限的也需要添加
        if(contextPath.equals("/api/sysuser/login")){
        	httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            chain.doFilter(request, response);
            return;
        }
        String auth = request1.getParameter("token");
        httpResponse.setContentType("application/json; charset=utf-8");
        if(auth==null){
        	auth =request1.getHeader("Authorization");
        }
        if ((auth != null) && (auth.length() > 7)) {
            Claims claims = JwtHelper.parseJWT(auth);
            if (claims != null) {
                JSONObject json=JSONObject.parseObject(claims.getSubject());
                //SysUser user = (SysUser)JSONObject.toJavaObject(json,SysUser.class);
                //UserUtils.setCurrentUser(user);
                httpResponse.setCharacterEncoding("UTF-8");
                httpResponse.setContentType("application/json; charset=utf-8");
                chain.doFilter(request, httpResponse);
                return;
            } else {

            }
        }
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_OK);
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With,admininfo");
        httpResponse.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        resultMsg = ResponseData.success(BusinessCodeEnum.SYS_TOKEN_WRONG.getMessage(), BusinessCodeEnum.SYS_TOKEN_WRONG.getCode());
        httpResponse.getWriter().write(JSONObject.toJSONString(resultMsg,SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.QuoteFieldNames,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteDateUseDateFormat,SerializerFeature.WriteNullListAsEmpty));
        return;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
}
