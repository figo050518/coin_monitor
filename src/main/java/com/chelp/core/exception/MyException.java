package com.chelp.core.exception;

/**

 * @ClassName: MyException

 * @Description: TODO

 * @author: zhonghui.geng

 * @date: 2016年11月25日 上午9:35:00

 */
public class MyException extends Exception {
	private static final long serialVersionUID = -621010413240370120L;
	private String message;
	
	private Integer code;
	
	public MyException(String message) {
        super(message);
    }

	
	public MyException( Integer code,String message) {
		super();
		this.message = message;
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
