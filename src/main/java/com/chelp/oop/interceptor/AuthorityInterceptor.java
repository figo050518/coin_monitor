package com.chelp.oop.interceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.chelp.core.common.ApiConfig;
import com.chelp.core.common.ResponseData;
import com.chelp.core.exception.MyException;
import com.chelp.core.utils.CodeHelper;
import com.chelp.core.utils.DesEncryptHelper;
import com.chelp.oop.common.BusinessCodeEnum;
import com.chelp.oop.utils.PropUtil;
import com.google.common.collect.Maps;

/**
 * 
 * @ClassName: AuthorityInterceptor 
 * @Description: 权限拦截器
 * @author jiangjun
 * @date 2017年4月14日 下午4:58:11
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class AuthorityInterceptor extends HandlerInterceptorAdapter implements HandlerInterceptor  {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws MyException,Exception {
		try {
			if (HandlerMethod.class.equals(handler.getClass())) {
					//参数解析
				String source=request.getParameter("source");
				String requestData=request.getParameter("requestData");
				if (CodeHelper.isNullOrEmpty(source) || CodeHelper.isNullOrEmpty(requestData)) {
					return  true;
					//return writeExceptionMessage(response, BusinessCodeEnum.MESSAGE_ERROR.getMessage(), BusinessCodeEnum.MESSAGE_ERROR.getCode());
				}else {
					if(PropUtil.getProperty("sys.encrypt").equals("true")){
						requestData = DesEncryptHelper.decryption(requestData, ApiConfig.APP_KEY);
					}
					JSONObject data = JSONObject.parseObject(requestData);
					String uid = data.getString("uid");
					String path = request.getRequestURI();
					Map map = new HashMap();
					if(uid==null){
						//uid = UserUtils.getCurrentUser().getId();
						uid="";
					}
					map.put("uid", uid);
					map.put("url", path);
					Map<String, List<String>> authorityMap = Maps.newHashMap();
					//request.setAttribute("requestData",JSONObject.toJSONString(data));
					JSONObject jsonObj = JSONObject.parseObject(requestData);
					Set<String> keySet =jsonObj.keySet();
					for (String key:keySet) {
						Object a = (Object)jsonObj.get(key);
						request.setAttribute(key,JSONObject.toJSONString(a));
					}
					return true;
				}
				//解密请求参数
			}
		}
	catch (Exception e) {
			e.printStackTrace();
			throw  e;
		}

		return writeExceptionMessage(response, BusinessCodeEnum.ILLEGAL_REQUEST.getMessage(), BusinessCodeEnum.ILLEGAL_REQUEST.getCode());
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	private boolean writeExceptionMessage(HttpServletResponse response, String message, int businessCode) {
		try {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(JSONObject.toJSONString(ResponseData.failure(message, businessCode)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
