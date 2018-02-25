package com.chelp.core.common;

import java.io.Serializable;
import java.util.Date;

public class AccountBean implements Serializable {
	/** 
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = -1273105788629657572L;
	/**
	 * 应用程序ID
	 */
	private String appId;
	/**
	 * 随机字符串
	 */
	private String nonceStr;
	/**
	 * 上一次调用时间
	 */
	private Date lastAccessDate;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public Date getLastAccessDate() {
		return lastAccessDate;
	}

	public void setLastAccessDate(Date lastAccessDate) {
		this.lastAccessDate = lastAccessDate;
	}
}
