package com.chelp.oop.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chelp.core.utils.CodeHelper;

public class ArithHelper {

	private ArithHelper() {
	}

	/**
	 * 
	 * @Title: add 
	 * @Description: 加法
	 * @param @param augend 被加数 
	 * @param @param addend 加数
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String add(String augend, String addend) {
		String defaultValue = "0";
		if (CodeHelper.isNullOrEmpty(augend))
			addend = defaultValue;
		if (CodeHelper.isNullOrEmpty(addend))
			augend = defaultValue;
		try {
			return new BigDecimal(augend).add(new BigDecimal(addend)).stripTrailingZeros().toPlainString();
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	/**
	 * 
	 * @Title: sub 
	 * @Description: 减法
	 * @param @param minuend 被减数 
	 * @param @param reduction 减数
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String sub(String minuend, String reduction) {
		String defaultValue = "0";
		if (CodeHelper.isNullOrEmpty(minuend))
			minuend = defaultValue;
		if (CodeHelper.isNullOrEmpty(reduction))
			return minuend;
		try {
			return new BigDecimal(minuend).subtract(new BigDecimal(reduction)).stripTrailingZeros().toPlainString();
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	/**
	 * 
	 * @Title: multiply 
	 * @Description: 乘法
	 * @param @param multiplicand 被乘数
	 * @param @param multiplier 乘数
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String multiply(String multiplicand, String multiplier) {
		return multiply(multiplicand, multiplier, 2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * @Title: multiply 
	 * @Description: 乘法
	 * @param @param multiplicand 被乘数
	 * @param @param multiplier 乘数
	 * @param @param scale 保留到小数点后位数
	 * @param @param roundingMode 舍入模式
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String multiply(String multiplicand, String multiplier, int scale, int roundingMode) {
		String defaultValue = "0";
		if (CodeHelper.isNullOrEmpty(multiplicand) || CodeHelper.isNullOrEmpty(multiplier))
			return defaultValue;
		try {
			return new BigDecimal(multiplicand).multiply(new BigDecimal(multiplier)).setScale(scale, roundingMode).stripTrailingZeros().toPlainString();
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	/**
	 * 
	 * @Title: divide 
	 * @Description: 除法
	 * @param @param dividend 被除数
	 * @param @param divisor 除数
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String divide(String dividend, String divisor) {
		return divide(dividend, divisor, 2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * @Title: divide 
	 * @Description: 除法
	 * @param @param dividend 被除数
	 * @param @param divisor 除数
	 * @param @param scale 保留到小数点后位数
	 * @param @param roundingMode 舍入模式
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String divide(String dividend, String divisor, int scale, int roundingMode) {
		String defaultValue = "0";
		if (CodeHelper.isNullOrEmpty(dividend) || CodeHelper.isNullOrEmpty(divisor))
			return defaultValue;
		if (new BigDecimal(divisor).compareTo(BigDecimal.ZERO) == 0)
			return defaultValue;
		try {
			return new BigDecimal(dividend).divide(new BigDecimal(divisor), scale, roundingMode).stripTrailingZeros().toPlainString();
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}

	/**
	 * 
	 * @Title: isPositiveNumber 
	 * @Description: 是否为正数
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isPositiveNumber(String str) {
		// String regx = "([1-9]\\d*(\\.\\d*[0-9])?)|(0\\.\\d*[0-9])";
		String regx = "([1-9]\\d*(\\.\\d{1,2})?)|(0\\.\\d{1,2})";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(str);
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @Title: isNegativeNumber 
	 * @Description: 是否为负数
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isNegativeNumber(String str) {
		int result = new BigDecimal(str).compareTo(BigDecimal.ZERO);
		if (result == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: isLessThanOrEqualZero 
	 * @Description: 小于等于0
	 * @param @param str
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isLessThanOrEqualZero(String str) {
		int result = new BigDecimal(str).compareTo(BigDecimal.ZERO);
		if (result <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: compareTo 
	 * @Description: 比较
	 * @param @param source
	 * @param @param target
	 * @param @return
	 * @return int
	 * @throws
	 */
	public static int compareTo(String source, String target) {
		return new BigDecimal(source).compareTo(new BigDecimal(target));
	}
}
