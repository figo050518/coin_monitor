package com.chelp.oop.common;

/**
 * 
 * @ClassName: BusinessCodeEnum 
 * @Description: 业务状态码
 * @author jiangjun
 * @date 2017年4月14日 上午10:38:39
 */
public enum BusinessCodeEnum {

	/**
	 * 成功
	 */
	SUCCESS(100, "成功"),
	/**
	 * 失败
	 */
	FAILURE(101, "失败"),
	/**
	 * 没有数据
	 */
	NO_DATA(102, "没有数据"),
	/**
	 * 报文错误
	 */
	MESSAGE_ERROR(103, "报文错误"),
	/**
	 * 参数格式校验错误
	 */
	PARAMETER_FORMAT_ERROR(104, "参数格式校验错误"),
	/**
	 * 参数不存在
	 */
	PARAMETER_DOES_NOT_EXIST(105, "参数不存在"),
	/**
	 * 转换数据失败
	 */
	CONVERSION_DATA_FAILED(106, "转换数据失败"),
	/**
	 * 网络异常
	 */
	NETWORK_ANOMALY(107, "网络异常"),
	/**
	 * 用户不存在
	 */
	USER_DOES_NOT_EXIST(108, "用户不存在"),
	/**
	 * 用户已停用
	 */
	USER_DISABLED(109, "用户已停用，请联系客服（4008288517）"),
	/**
	 * 账户不存在
	 */
	ACCOUNT_DOES_NOT_EXIST(110, "账户不存在"),
	/**
	 * 账户已停用
	 */
	ACCOUNT_DISABLED(111, "账户已停用，请联系客服（4008288517）"),
	/**
	 * 账户被冻结
	 */
	ACCOUNT_FREEZE(112, "账户被冻结，请联系客服（4008288517）"),
	/**
	 * 账户余额不足
	 */
	INSUFFICIENT_ACCOUNT_BALANCE(113, "账户余额不足，请充值"),
	/**
	 * 站点已停用
	 */
	STATION_DISABLED(114, "站点已停用，请联系客服（4008288517）"),
	/**
	 * 电桩已停用
	 */
	PILE_DISABLED(115, "电桩已停用，请联系客服（4008288517）"),
	/**
	 * 权限不足
	 */
	NO_PERMISSIONS(116, "权限不足"),
	/**
	 * 非法请求
	 */
	ILLEGAL_REQUEST(117, "非法请求"),
	/**
	 * 您的密码为初始密码，请修改后使用
	 */
	WEAK_PASSWORD(118, "您的密码为初始密码，请修改后使用"),
	/**
	 * 您的软件当前版本过低，请升级至最新版本
	 */
	VERSION_LOW(119, "您的软件当前版本过低，请升级至最新版本"),
	/**
	 * 密码错误
	 */
	PASSWORD_ERROR(120, "密码错误"),
	/**
	 * 已关联用户的角色
	 */
	ROLE_RELATED(121, "不能修改已经关联用户的机构角色！"),
	/**
	 * 已关联用户的角色
	 */
	NEED_LOGIN(122, "会话结束，请重新登录！"),
	/**
	 * 已关联用户的角色
	 */
	MEMBER_CARD_OVER_DATE(123, "会员卡已经过去！"),
	/**
	 * token 错误 sys 错误 900 开头，
	 */
	SYS_TOKEN_WRONG(900, "token错误！"),

	/**
	 * 权限被修改 需要重新登录
	 */
	AUTH_TIME_OUT(901, "权限过期，重新登录！");

	private int code;

	private String message;

	private BusinessCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
