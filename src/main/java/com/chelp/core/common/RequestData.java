package com.chelp.core.common;

import java.io.Serializable;

/**
 * 
 * @ClassName: RequestData 
 * @Description: 请求对象
 * @author jiangjun
 * @date 2017年4月12日 下午6:34:34
 */
public class RequestData implements Serializable {

	/** 
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = 6116391864992299451L;

	/**
	 * 来源。web或app
	 */
	private String source;

	/**
	 * 版本号
	 */
	private String vsersion;

	/**
	 * 请求内容
	 */
	private Object requestData;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getVsersion() {
		return vsersion;
	}

	public void setVsersion(String vsersion) {
		this.vsersion = vsersion;
	}

	public Object getRequestData() {
		return requestData;
	}

	public void setRequestData(Object requestData) {
		this.requestData = requestData;
	}
}
