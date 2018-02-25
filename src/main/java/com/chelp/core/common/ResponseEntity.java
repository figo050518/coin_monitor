
package com.chelp.core.common;

import java.io.Serializable;

/**
 * 
 * @ClassName: ResponseEntity 
 * @Description: 响应对象
 * @author jiangjun
 * @date 2017年3月3日 上午10:08:49
 */
public class ResponseEntity implements Serializable {

	/** 
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = 9120195730478849979L;

	/**
	 * 状态码
	 */
	private String returnCode;

	/**
	 * 消息
	 */
	private String returnMsg;

	/**
	 * 响应内容
	 */
	private Object returnData;

	private static final String SUCCESS = "SUCCESS";

	private static final String FAIL = "FAIL";

	private static final String EMPTY_MSG = "";

	public ResponseEntity(String returnCode) {
		super();
		this.returnCode = returnCode;
	}

	public ResponseEntity(Object returnData) {
		super();
		this.returnData = returnData;
	}

	public ResponseEntity(String returnCode, String returnMsg) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
	}

	public ResponseEntity(String returnCode, String returnMsg, Object returnData) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.returnData = returnData;
	}

	public static ResponseEntity success(Object returnData) {
		return new ResponseEntity(SUCCESS, EMPTY_MSG, returnData);
	}

	public static ResponseEntity success(String returnCode, Object returnData) {
		return new ResponseEntity(returnCode, EMPTY_MSG, returnData);
	}

	public static ResponseEntity success(String returnCode, String returnMsg, Object returnData) {
		return new ResponseEntity(returnCode, returnMsg, returnData);
	}

	public static ResponseEntity failure() {
		return new ResponseEntity(FAIL, EMPTY_MSG);
	}

	public static ResponseEntity failure(String returnMsg) {
		return new ResponseEntity(FAIL, returnMsg);
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}
}
