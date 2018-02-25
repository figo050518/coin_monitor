package com.chelp.oop.common;

/**
 * 
 * @ClassName: QueryCriteriaBean 
 * @Description: 筛选条件
 * @author jiangjun
 * @date 2017年5月19日 上午11:07:22
 */
public class QueryCriteriaBean {
	/**
	 * 机构
	 */
	public static final int COMPANY = 1;
	/**
	 * 站点
	 */
	public static final int STATION = 2;
	/**
	 * 角色
	 */
	public static final int ROLE = 3;
	/**
	 * 账户类型（普通账户，优惠账户，快充币）
	 */
	public static final int ACCOUNT_TYPE = 4;
	/**
	 * 流水类型（1：出账流水，2：入账流水）
	 */
	public static final int FLOW_TYPE = 5;
	/**
	 * 车辆绑定状态（1：未绑定，2：待绑定，3：绑定成功，4：绑定失败）
	 */
	public static final int VEHICLE_BOUND_STATUS = 6;
	/**
	 * 开放性（1：对外，2：对内，3：对外仅大客车）
	 */
	public static final int SERVICE_OBJECT = 7;
}
