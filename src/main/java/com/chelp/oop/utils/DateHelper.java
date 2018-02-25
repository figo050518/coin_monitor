package com.chelp.oop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

public class DateHelper {

	public static final String Y = "yyyy";

	public static final String Y_M = "yyyy-MM";

	public static final String Y_M_D = "yyyy-MM-dd";

	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";

	public static final String Y_M_D_H_M_S_S = "yyyyMMddHHmmssSSS";

	public static final String MM_DD = "MM月dd日";

	private DateHelper() {

	}

	public static String getFormatDate() {
		return getFormatDate(Y_M_D, new Date());
	}

	public static String getFormatDate(String format) {
		return getFormatDate(format, new Date());
	}

	public static String getFormatDate(Date date) {
		return getFormatDate(Y_M_D, date);
	}

	public static String getFormatDate(String format, Date date) {
		return new SimpleDateFormat(format).format(date);
	}

	public static String getFormatDate(String format, String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(dateFormat.parse(date));
	}

	public static String getFormatYesterday() {
		return getFormatYesterday(Y_M_D, new Date());
	}

	public static String getFormatYesterday(String format) {
		return getFormatYesterday(format, new Date());
	}

	public static String getFormatYesterday(Date date) {
		return getFormatYesterday(Y_M_D, date);
	}

	public static String getFormatYesterday(String format, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		return getFormatDate(format, calendar.getTime());
	}

	public static String getYesterdayStartTime() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return getFormatDate(Y_M_D_H_M_S, calendar.getTime());
	}

	public static String getYesterdayStartTime(String format) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return getFormatDate(format, calendar.getTime());
	}

	public static String getYesterdayStartTime(String format, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return getFormatDate(format, calendar.getTime());
	}

	public static String getYesterdayStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return getFormatDate(Y_M_D_H_M_S, calendar.getTime());
	}

	public static Date parseDate(String source) {
		try {
			return new SimpleDateFormat(Y_M_D).parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}
