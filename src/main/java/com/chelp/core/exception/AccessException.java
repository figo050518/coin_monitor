package com.chelp.core.exception;

/**
 * 
 * @ClassName: AccessException 
 * @Description: 自定义访问控制异常
 * @author jiangjun
 * @date 2017年3月7日 下午5:24:24
 */
public class AccessException extends Exception {

	/** 
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;

	public AccessException(String msg) {
		super(msg);
	}

}
