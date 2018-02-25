package com.chelp.oop.common;

/**
 * 
 * @ClassName: FlowTypeBean 
 * @Description: 流水类型
 * @author jiangjun
 * @date 2017年5月26日 上午10:41:55
 */
public class FlowTypeBean {

	/**
	 * 
	 * @ClassName: NormalUserAccountFlowType 
	 * @Description: 员工流水类型
	 * @author jiangjun
	 * @date 2017年5月26日 上午10:42:07
	 */
	public static class NormalUserAccountFlowType {
		/**
		 * 主账户分配
		 */
		public static final String NORMAL_USER_ACCOUNT_FLOW_TYPE_15 = "15";
		/**
		 * 退回主账户
		 */
		public static final String NORMAL_USER_ACCOUNT_FLOW_TYPE_16 = "16";
		/**
		 * 欠费抵扣
		 */
		public static final String NORMAL_USER_ACCOUNT_FLOW_TYPE_25 = "25";
	}

	/**
	 * 
	 * @ClassName: CompanyAccountFlowType 
	 * @Description: 机构流水类型
	 * @author jiangjun
	 * @date 2017年5月26日 上午10:42:14
	 */
	public static class CompanyAccountFlowType {
		/**
		 * 充值
		 */
		public static final String COMPANY_ACCOUNT_FLOW_TYPE_1 = "1";
		/**
		 * 分配到子账户
		 */
		public static final String COMPANY_ACCOUNT_FLOW_TYPE_2 = "2";
		/**
		 * 子账户退回
		 */
		public static final String COMPANY_ACCOUNT_FLOW_TYPE_3 = "3";
		/**
		 * 财务扣款
		 */
		public static final String COMPANY_ACCOUNT_FLOW_TYPE_4 = "4";
		/**
		 * 主账户分配
		 */
		public static final String COMPANY_ACCOUNT_FLOW_TYPE_5 = "5";
	}
}
