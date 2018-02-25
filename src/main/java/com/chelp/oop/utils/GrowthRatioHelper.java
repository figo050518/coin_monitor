package com.chelp.oop.utils;

import java.math.BigDecimal;

import com.chelp.core.utils.CodeHelper;

/**
 * 
 * @ClassName: GrowthRatioHelper 
 * @Description: 环比增长计算工具类
 * @author jiangjun
 * @date 2017年4月18日 上午9:50:58
 */
public class GrowthRatioHelper {

	private GrowthRatioHelper() {
	}

	public static String calculateGrowthRatio(String yesterday, String today) {
		return calculateGrowthRatio(yesterday, today, 2, BigDecimal.ROUND_HALF_UP);
	}

	public static String calculateGrowthRatio(String yesterday, String today, int scale, int roundingMode) {
		String defaultValue = "0";
		try {
			if (CodeHelper.isNullOrEmpty(yesterday))
				return defaultValue;

			if (CodeHelper.isNullOrEmpty(today))
				today = defaultValue;

			BigDecimal yesterdayData = new BigDecimal(yesterday);
			BigDecimal todayData = new BigDecimal(yesterday);

			if (yesterdayData.compareTo(BigDecimal.ZERO) == 0)
				return defaultValue;

			return ((todayData.subtract(yesterdayData)).divide(yesterdayData)).setScale(scale, roundingMode).stripTrailingZeros().toPlainString();
		} catch (Exception e) {
			e.printStackTrace();
			return defaultValue;
		}
	}
}
