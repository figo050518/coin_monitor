/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.chelp.oop.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Cache工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class BiginsUtils {
	
	  public  final int CHINA_ID_MIN_LENGTH = 15;

	    /** 中国公民身份证号码最大长度。 */
	    public  final int CHINA_ID_MAX_LENGTH = 18;
	    /**
	     * 根据身份编号获取年龄
	     *
	     * @param idCard
	     *            身份编号
	     * @return 年龄
	     */
	    public static int getAgeByIdCard(String idCard) {
	        int iAge = 0;
	        Calendar cal = Calendar.getInstance();
	        String year = idCard.substring(6, 10);
	        int iCurrYear = cal.get(Calendar.YEAR);
	        iAge = iCurrYear - Integer.valueOf(year);
	        return iAge;
	    }

	    /**
	     * 根据身份编号获取生日
	     *
	     * @param idCard 身份编号
	     * @return 生日(yyyy-MM-dd)
	     */
	    public static String getBirthByIdCard(String idCard) {
	    	String year = idCard.substring(6, 10);
	    	String month = idCard.substring(10, 12);
	    	String day = idCard.substring(12, 14);
	        return year+"-"+month+"-"+day;
	    }

	    /**
	     * 根据身份编号获取生日年
	     *
	     * @param idCard 身份编号
	     * @return 生日(yyyy)
	     */
	    public static Short getYearByIdCard(String idCard) {
	        return Short.valueOf(idCard.substring(6, 10));
	    }

	    /**
	     * 根据身份编号获取生日月
	     *
	     * @param idCard
	     *            身份编号
	     * @return 生日(MM)
	     */
	    public static Short getMonthByIdCard(String idCard) {
	        return Short.valueOf(idCard.substring(10, 12));
	    }

	    /**
	     * 根据身份编号获取生日天
	     *
	     * @param idCard
	     *            身份编号
	     * @return 生日(dd)
	     */
	    public static Short getDateByIdCard(String idCard) {
	        return Short.valueOf(idCard.substring(12, 14));
	    }

	    /**
	     * 根据身份编号获取性别
	     *
	     * @param idCard 身份编号
	     * @return 性别(M-男，F-女，N-未知)
	     */
	    public static String getGenderByIdCard(String idCard) {
	        String sGender = "未知";

	        String sCardNum = idCard.substring(16, 17);
	        if (Integer.parseInt(sCardNum) % 2 != 0) {
	            sGender = "1";//男
	        } else {
	            sGender = "2";//女
	        }
	        return sGender;
	    }
	    
	    public static String getAccountFlow(){  
	        String id="";  
	        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");  
	        String temp = sf.format(new Date());  
	        int random=(int) (Math.random()*10000);  
	        id=temp+random;  
	        return id;  
	    }  
	    public static String getOrderNo(){  
	        String id="";  
	        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");  
	        String temp = sf.format(new Date());  
	        int random=(int) (Math.random()*10000);  
	        id=temp+random;  
	        return id;  
	    } 
	
}
