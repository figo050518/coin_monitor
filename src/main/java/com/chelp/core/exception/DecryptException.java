package com.chelp.core.exception;

/**
 * 
 * @ClassName: DecryptException 
 * @Description: 自定义参数解密异常
 * @author jiangjun
 * @date 2017年4月13日 下午3:11:54
 */
public class DecryptException extends Exception {

	/** 
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -4345525865359693755L;

	public DecryptException(String msg) {
		super(msg);
	}
}
