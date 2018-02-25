package com.chelp.core.exception;

/**
 * 
 * @ClassName: EncryptException 
 * @Description: 自定义参数加密异常
 * @author jiangjun
 * @date 2017年3月3日 下午3:55:34
 */
public class EncryptException extends Exception {

	/** 
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	public EncryptException(String msg) {
		super(msg);
	}

}
