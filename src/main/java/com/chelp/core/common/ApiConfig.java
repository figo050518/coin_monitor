package com.chelp.core.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.chelp.core.utils.PropertyHelper;

/**
 * 
 * @ClassName: ApiConfig 
 * @Description: TODO
 * @author jiangjun
 * @date 2017年2月28日 下午2:48:43
 */
public class ApiConfig implements Serializable {

	/** 
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = -1344657135586164640L;

	/**
	 * 应用ID
	 */
	public static final String APP_ID = PropertyHelper.getPropertyValue("appid");
	/**
	 * DES加密用key
	 */
	public static final String APP_KEY = PropertyHelper.getPropertyValue("appKey");
	/**
	 * 请求参数签名用密钥
	 */
	public static final String APP_SECRET = PropertyHelper.getPropertyValue("appSecret");
	/**
	 * 编码
	 */
	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 接口名集合
	 */
	public static final JSONObject METHOD_NAME = JSONObject.parseObject(PropertyHelper.getPropertyValue("methodName"));
}
