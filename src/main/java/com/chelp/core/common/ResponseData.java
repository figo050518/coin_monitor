package com.chelp.core.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chelp.core.exception.EncryptException;
import com.chelp.core.utils.DesEncryptHelper;

/**
 * 
 * @ClassName: ResponseData 
 * @Description: 响应对象
 * @author jiangjun
 * @date 2017年4月12日 下午6:33:32
 */
public class ResponseData implements Serializable {

	/** 
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = 2487842315053100528L;

	/**
	 * 状态码
	 */
	private String returnCode;

	/**
	 * 业务状态码，参考com.chelp.core.common.BusinessCodeEnum
	 */
	private int businessCode;

	/**
	 * 消息
	 */
	private String returnMsg;

	/**
	 * 响应内容
	 */
	private Object returnData;

	public ResponseData(String returnCode, String returnMsg, Object returnData, int businessCode) {
		super();
		this.returnCode = returnCode;
		this.returnMsg = returnMsg;
		this.businessCode = businessCode;
		this.returnData = getReturnData(returnData);
	}

	public static ResponseData success() {
		return success(Constants.SUCCESS, Constants.EMPTY_MSG, Constants.EMPTY_STRING, 100);
	}

	public static ResponseData success(Object returnData) {
		System.out.print(returnData);
		return success(Constants.SUCCESS, Constants.EMPTY_MSG, returnData, 100);
	}

	public static ResponseData success(String returnMsg, int businessCode) {
		return success(Constants.SUCCESS, returnMsg, Constants.EMPTY_STRING, businessCode);
	}

	public static ResponseData success(String returnMsg, Object returnData, int businessCode) {
		return success(Constants.SUCCESS, returnMsg, returnData, businessCode);
	}

	public static ResponseData success(String returnMsg, Object returnData) {
		return success(Constants.SUCCESS, returnMsg, returnData, 100);
	}

	public static ResponseData success(String returnCode, String returnMsg, Object returnData, int businessCode) {
		return new ResponseData(returnCode, returnMsg, returnData, businessCode);
	}

	public static ResponseData failure() {
		return failure(Constants.FAILURE, Constants.EMPTY_MSG, Constants.EMPTY_STRING, 101);
	}

	public static ResponseData failure(Object returnData) {
		return failure(Constants.FAILURE, Constants.EMPTY_MSG, returnData, 101);
	}

	public static ResponseData failure(String returnMsg, Object returnData) {
		return failure(Constants.FAILURE, returnMsg, returnData, 101);
	}

	public static ResponseData failure(String returnMsg, int businessCode) {
		return failure(Constants.FAILURE, returnMsg, Constants.EMPTY_STRING, businessCode);
	}

	public static ResponseData failure(String returnMsg, Object returnData, int businessCode) {
		return failure(Constants.FAILURE, returnMsg, returnData, businessCode);
	}

	public static ResponseData failure(String returnCode, String returnMsg, Object returnData, int businessCode) {
		return new ResponseData(returnCode, returnMsg, returnData, businessCode);
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public int getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(int businessCode) {
		this.businessCode = businessCode;
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

	private String getReturnData(Object returnData) {
			return JSONObject.toJSONString(returnData, SerializerFeature.DisableCircularReferenceDetect);
	}

	private void encryptException() {
		this.returnCode = Constants.FAILURE;
		this.businessCode = 101;
		this.returnMsg = MessageEnum.DES_ENCRYPTION_FAILED.getMessage();
	}
}
