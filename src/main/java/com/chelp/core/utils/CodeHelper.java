
package com.chelp.core.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.chelp.core.common.Constants;

/**
 * 
 * @ClassName: CodeHelper 
 * @Description: 帮助类
 * @author jiangjun
 * @date 2017年2月28日 下午2:54:20
 */
public class CodeHelper {

	private CodeHelper() {
	}

	public static boolean isNull(Object param) {
		return null == param;
	}

	public static boolean isNotNull(Object param) {
		return null != param;
	}

	public static boolean isNotNullOrEmpty(List<? extends Object> list) {
		return CodeHelper.isNotNull(list) && !list.isEmpty();
	}

	public static boolean isNotNullOrEmpty(Map<? extends Object, ? extends Object> map) {
		return CodeHelper.isNotNull(map) && !map.isEmpty();
	}

	public static boolean isNotNullOrEmpty(String str) {
		return CodeHelper.isNotNull(str) && !str.isEmpty();
	}

	public static boolean isNullOrEmpty(String str) {
		return CodeHelper.isNull(str) || str.isEmpty();
	}

	public static boolean isNotNullOrEmpty(Integer params) {
		return CodeHelper.isNotNull(params) && params.intValue() > Constants.INT_ZERO;
	}

	public static boolean isNotNullOrEmpty(Long params) {
		return CodeHelper.isNotNull(params) && params.longValue() > Constants.INT_ZERO;
	}

	public static boolean isNotNullOrEmpty(Object[] params) {
		return CodeHelper.isNotNull(params) && params.length > 0;
	}

	public static boolean isNullOrEmpty(Collection<?> list) {
		return CodeHelper.isNull(list) || list.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<? extends Object, ? extends Object> map) {
		return CodeHelper.isNull(map) || map.isEmpty();
	}
}
