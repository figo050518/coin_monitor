
package com.chelp.core.utils;

import java.io.InputStream;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @ClassName: PropertyHelper 
 * @Description: 配置文件工具类
 * @author jiangjun
 * @date 2017年3月7日 下午3:09:53
 */
public class PropertyHelper {
	private PropertyHelper() {
	}

	private static Properties properties = new Properties();

	public static String getPropertyValue(String key) {
		return getPropertyValue(key, null);
	}

	public static String getPropertyValue(String key, String fileName) {
		return getPropertyValue(key, fileName, null);
	}

	public static String getPropertyValue(String key, String fileName, String filePath) {
		if (null == fileName) {
			fileName = "config";
		}
		if (null == filePath) {
			filePath = "others";
		}

		String resultValue = null;

		try {

			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("/" + filePath + "/" + fileName + ".properties");

			properties.load(inputStream);

			resultValue = properties.getProperty(key);

		} catch (MissingResourceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultValue;
	}

	public static String replacePlaceholder(String value, String[] values) {
		if (null != value) {
			if (null == values || values.length == 0) {
				return null;
			}

			StringBuffer buffer = new StringBuffer();

			for (int i = 0; i < values.length; i++) {
				buffer.delete(0, buffer.length());

				Pattern pattern = Pattern.compile("\\{" + i + "\\}");

				Matcher matcher = pattern.matcher(value);

				while (matcher.find()) {
					matcher.appendReplacement(buffer, values[i]);
				}
				matcher.appendTail(buffer);

				value = buffer.toString();
			}
			return value;
		}
		return null;
	}

	public static String replacePlaceholder(String key, String fileName, String filePath, String[] values) {
		String resultValue = getPropertyValue(key, fileName, filePath);

		if (null != resultValue) {
			if (null == values || values.length == 0) {
				return null;
			}

			StringBuffer buffer = new StringBuffer();

			for (int i = 0; i < values.length; i++) {
				buffer.delete(0, buffer.length());

				Pattern pattern = Pattern.compile("\\{" + i + "\\}");

				Matcher matcher = pattern.matcher(resultValue);

				while (matcher.find()) {
					matcher.appendReplacement(buffer, values[i]);
				}
				matcher.appendTail(buffer);

				resultValue = buffer.toString();
			}
			return resultValue;
		}
		return null;
	}
}
