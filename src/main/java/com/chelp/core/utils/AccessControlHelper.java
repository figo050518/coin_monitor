package com.chelp.core.utils;

import java.util.Date;

import com.chelp.core.common.AccountBean;
import com.chelp.core.common.ApiConfig;
import com.chelp.core.common.MessageEnum;
import com.chelp.core.exception.AccessException;

/**
 * 
 * @ClassName: AccessControlHelper 
 * @Description: 访问控制
 * @author jiangjun
 * @date 2017年3月8日 上午9:17:45
 */
public class AccessControlHelper {

	private AccessControlHelper() {
	}

	/**
	 * 
	 * @Title: checkAccess 
	 * @Description: 访问控制，包括访问频率及链接是否失效
	 * @param @param appId 应用程序ID
	 * @param @param methodName 请求方法（接口）名
	 * @param @param nonceStr 随机字符串，调用方生成
	 * @param @throws AccessException
	 * @return void
	 * @throws
	 */
	public static void checkAccess(String appId, String methodName, String nonceStr) throws AccessException {
		if (CodeHelper.isNullOrEmpty(appId) || CodeHelper.isNullOrEmpty(methodName) || CodeHelper.isNullOrEmpty(nonceStr) || !ApiConfig.METHOD_NAME.containsKey(methodName))
			throw new AccessException(MessageEnum.PARAMETER_FORMAT_ERROR.getMessage());
		// 缓存当中存有当前账户信息，则校验，否则放行
		if (null != CacheHelper.get(appId)) {
			// 时长，分钟为单位
			int minute = ApiConfig.METHOD_NAME.getIntValue(methodName);
			AccountBean account = null;
			long difference = 0; // 距上次请求时差（秒）
			try {
				account = (AccountBean) CacheHelper.get(appId);
				difference = new Date().getTime() - account.getLastAccessDate().getTime();
			} catch (Exception e) {
				e.printStackTrace();
				throw new AccessException(MessageEnum.PARAMETER_FORMAT_ERROR.getMessage());
			}
			// 重复请求，链接失效
			if (nonceStr.equals(account.getNonceStr()))
				throw new AccessException(MessageEnum.REQUEST_LINK_FAILED.getMessage());
			// 请求频率过高
			if (difference <= (minute * 3600))
				throw new AccessException(MessageEnum.HIGH_FREQUENCY.getMessage());
		}
	}
}
