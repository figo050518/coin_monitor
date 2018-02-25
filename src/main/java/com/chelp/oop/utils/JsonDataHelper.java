package com.chelp.oop.utils;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chelp.core.utils.CodeHelper;

public class JsonDataHelper {

	private JsonDataHelper() {
	}

	public static String getStringValue(JSONObject data, String key, String defaultValue) {
		if (data.containsKey(key) && CodeHelper.isNotNullOrEmpty(data.getString(key))) {
			return data.getString(key);
		}
		return defaultValue;
	}

	public static int getIntValue(JSONObject data, String key, int defaultValue) {
		if (data.containsKey(key) && CodeHelper.isNotNullOrEmpty(data.getInteger(key))) {
			return data.getInteger(key);
		}
		return defaultValue;
	}

	public static <T> List<T> getListValue(JSONObject data, String key, Class<T> c) {
		if (data.containsKey(key) && data.get(key) != null) {
			if (data.get(key) instanceof String) {
				String res = (String) data.get(key);
				return JSONArray.parseArray(res, c);
			} else if (data.get(key) instanceof JSONArray) {
				return JSONArray.parseArray(data.getJSONArray(key).toJSONString(), c);
			}
			return null;
		}
		return null;
	}
}
