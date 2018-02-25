package oop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class UserParamsUtils {

	public static void buildLoginParams(JSONObject jsonObject) {
		jsonObject.put("loginName", "0428	");
		jsonObject.put("password", "123456");
	}

	public static void buildQueryCriteria(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("criteria", "1,2,3,4,5,6,7");
	}

	public static void buildAppIndexParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("city", "南京");
	}

	public static void buildAppOverviewParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("dimensionality", "year");
		jsonObject.put("zeroFill", "0");
		jsonObject.put("querys", JSONArray.parseArray("[{'city':'南京','area':'雨花台','stationId':'2'},{'city':'南京','area':'鼓楼','stationId':'1'}]"));
		jsonObject.put("company", "6d782cc2d2e311e6ab26a0481ca8c7f7");
		jsonObject.put("startDate", "2010-01-01");
		jsonObject.put("endDate", "2017-05-08");
	}

	public static void buildAppPersonalCenterParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
	}

	public static void buildAppMyStaffParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("userAccount", "1"); // 用户帐号（normal_user：phone）
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildAppMyStaffFlowParams(JSONObject jsonObject) {
		jsonObject.put("userId", "273");
		jsonObject.put("flowType", "1");// 1：出账流水，2：入账流水
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildAppMyCompanyParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("userAccount", "1"); // 机构名称（sys_user：name）
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildAppMyCompanyFlowParams(JSONObject jsonObject) {
		jsonObject.put("company", "1");
		jsonObject.put("flowType", "1"); // 1：出账流水，2：入账流水
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildAppProcessParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildAppChargeRecordParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
		jsonObject.put("startDate", "2010-01-01");
		jsonObject.put("endDate", "2017-05-08");
	}

	public static void buildAppmyWallet(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("flowType", "1"); // 1：出账流水，2：入账流水
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildWebIndexParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("city", "南京");
	}

	public static void buildWebHomePageParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("city", "南京");
	}

	public static void buildWebOverviewParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("dimensionality", "year");
		jsonObject.put("zeroFill", "0");
		jsonObject.put("querys", JSONArray.parseArray("[{'city':'南京','area':'雨花台','stationId':'2'},{'city':'南京','area':'鼓楼','stationId':'1'}]"));
		jsonObject.put("company", "6d782cc2d2e311e6ab26a0481ca8c7f7");
		jsonObject.put("startDate", "2010-01-01");
		jsonObject.put("endDate", "2017-05-08");
	}

	public static void buildWebDataByCompanyParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("company", "6d782cc2d2e311e6ab26a0481ca8c7f7");
		jsonObject.put("startDate", "2010-01-01");
		jsonObject.put("endDate", "2017-05-08");
	}

	public static void buildWebDataBySingleCompanyParams(JSONObject jsonObject) {
		jsonObject.put("company", "6d782cc2d2e311e6ab26a0481ca8c7f7");
		jsonObject.put("dimensionality", "year");
		jsonObject.put("zeroFill", "0");
		jsonObject.put("startDate", "2010-01-01");
		jsonObject.put("endDate", "2017-05-08");
	}

	public static void buildWebDataByUserParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("company", "1");
		jsonObject.put("startDate", "2010-01-01");
		jsonObject.put("endDate", "2017-05-08");
	}

	public static void buildWebDataBySingleUserParams(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("userId", "284");
		jsonObject.put("dimensionality", "year");
		jsonObject.put("zeroFill", "0");
		jsonObject.put("startDate", "2016-01-01");
		jsonObject.put("endDate", "2016-12-01");
	}

	public static void buildWebFindUserByCompanyIdParams(JSONObject jsonObject) {
		jsonObject.put("company", "6d782cc2d2e311e6ab26a0481ca8c7f7");
	}

	public static void buildWebEmployeeList(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("institution", "1");
		jsonObject.put("account", "18780589593");
		jsonObject.put("role", "2");
		jsonObject.put("phone", "18780589593");
		jsonObject.put("cardNumber", "3114495535");
		jsonObject.put("vehicleBoundStatus", "1");
		jsonObject.put("plateNumber", "苏A12585");
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildWebEmployeeDetailsInfo(JSONObject jsonObject) {
		jsonObject.put("userId", "619");
	}

	public static void buildWebUpdateEmployeeAccountStatus(JSONObject jsonObject) {
		jsonObject.put("userId", "619");
		jsonObject.put("accountStatus", "1");
	}

	public static void buildWebUpdateEmployeeInfo(JSONObject jsonObject) {
		jsonObject.put("userId", "619");
		jsonObject.put("institution", "1");
		jsonObject.put("role", "2");
		jsonObject.put("accountType", "1");
		jsonObject.put("name", "");
		jsonObject.put("phone", "18780589593");
		jsonObject.put("cardNumber", "3114495535");
		jsonObject.put("email", "email@qq.com");
		jsonObject.put("travelLicensePictures", "123");
		jsonObject.put("remark", "123");
		jsonObject.put("vehicleAuditStatus", "3");
		jsonObject.put("accountStatus", "1");
	}

	public static void buildWebInstitutionList(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("institutionName", "1");
		jsonObject.put("phone", "1");
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildWebAllocationEmployeeAccount(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("institutionId", "6f6d782f252f447a84ec63ac54bb9b83");
		jsonObject.put("assignedUserId", "278");
		jsonObject.put("distributionAmount", "90032.07");
	}

	public static void buildWebAllocationInstitutionalAccount(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("institutionId", "6f6d782f252f447a84ec63ac54bb9b83");
		jsonObject.put("assignedInstitutionId", "6ce4f1a2a7d24618b5972a47e10c6963");
		jsonObject.put("distributionAmount", "0.03");
	}

	public static void buildWebEmployeeFlow(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("flowType", "1");// 1：出账流水，2：入账流水
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}

	public static void buildWebInstitutionFlow(JSONObject jsonObject) {
		jsonObject.put("uid", "1");
		jsonObject.put("flowType", "1"); // 1：出账流水，2：入账流水
		jsonObject.put("pageIndex", "1");
		jsonObject.put("pageSize", "5");
	}
}
