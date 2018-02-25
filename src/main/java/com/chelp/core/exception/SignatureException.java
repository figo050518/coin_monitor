package com.chelp.core.exception;

/**
 * 
 * @ClassName: SignatureException 
 * @Description: 自定义签名异常
 * @author jiangjun
 * @date 2017年3月3日 下午3:56:07
 */
public class SignatureException extends Exception {

	/** 
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	public SignatureException(String msg) {
		super(msg);
	}

}
