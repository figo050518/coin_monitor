package oop;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.chelp.core.exception.EncryptException;
import com.chelp.core.utils.CodeHelper;
import com.chelp.core.utils.DesEncryptHelper;
import com.chelp.core.utils.HttpHelper;

public class UserWebTest {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(UserWebTest.class);

		String params = "source=web&version=1&token="
				+ "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0OTczMTc4NDksInN1YiI6IntcImlkXCI6XCIxXCIsXCJyb2xlSWRcIjpcIjFcIn0iLCJleHAiOjE0OTc0MDQyNDl9.z41M0iCccqJ9L2aX8-6WzYImJgxemlMrejR2AovaS4Y"
				+ "&requestData=";

		JSONObject jsonObject = new JSONObject(true);

		// 登录
		// String requestUrl = "http://192.168.1.48:18080/oop/common/api/login";
		// UserParamsUtils.buildLoginParams(jsonObject);

		// 公共查询参数
		// String requestUrl = "http://192.168.1.48:18080/oop/common/api/queryCriteria";
		// UserParamsUtils.buildQueryCriteria(jsonObject);

		// 首页-我的充电
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/index";
		// UserParamsUtils.buildWebIndexParams(jsonObject);

		// 首页-我的充电-折线图（最近7天充电记录）-环线图（充电次数比例）
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/homePage";
		// UserParamsUtils.buildWebHomePageParams(jsonObject);

		// 统计分析-我的员工-充电总览
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/overview";
		// UserParamsUtils.buildWebOverviewParams(jsonObject);

		// 统计分析-我的员工-按机构统计
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/dataByCompany";
		// UserParamsUtils.buildWebDataByCompanyParams(jsonObject);

		// 统计分析-我的员工-按机构统计-单机构充电统计
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/dataBySingleCompany";
		// UserParamsUtils.buildWebDataBySingleCompanyParams(jsonObject);

		// 统计分析-我的员工-按用户统计
		String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/dataByUser";
		UserParamsUtils.buildWebDataByUserParams(jsonObject);

		// 统计分析-我的员工-按用户统计-单用户充电统计
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/dataBySingleUser";
		// UserParamsUtils.buildWebDataBySingleUserParams(jsonObject);

		// 统计分析-我的员工-按用户统计-机构用户联动
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/findUserByCompanyId";
		// UserParamsUtils.buildWebFindUserByCompanyIdParams(jsonObject);

		// 员工管理-员工列表
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/employeeList";
		// UserParamsUtils.buildWebEmployeeList(jsonObject);

		// 员工管理-员工详细信息
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/employeeDetailsInfo";
		// UserParamsUtils.buildWebEmployeeDetailsInfo(jsonObject);

		// 员工管理-停用/启用
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/updateEmployeeAccountStatus";
		// UserParamsUtils.buildWebUpdateEmployeeAccountStatus(jsonObject);

		// 员工管理-编辑
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/updateEmployeeInfo";
		// UserParamsUtils.buildWebUpdateEmployeeInfo(jsonObject);

		// 员工管理-机构列表
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/institutionList";
		// UserParamsUtils.buildWebInstitutionList(jsonObject);

		// 员工管理-机构分配到员工账户
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/allocationEmployeeAccount";
		// UserParamsUtils.buildWebAllocationEmployeeAccount(jsonObject);

		// 员工管理-机构分配到子机构账户
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/allocationInstitutionalAccount";
		// UserParamsUtils.buildWebAllocationInstitutionalAccount(jsonObject);

		// 员工管理-员工流水
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/employeeFlow";
		// UserParamsUtils.buildWeSbEmployeeFlow(jsonObject);

		// 员工管理-机构流水
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/institutionFlow";
		// UserParamsUtils.buildWebInstitutionFlow(jsonObject);

		try {
			params += URLEncoder.encode(DesEncryptHelper.encryption(jsonObject.toJSONString(), "c50f1d4657014620a004fc96e295451b"), "UTF-8");
		} catch (EncryptException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		logger.debug("-----请求报文-----：" + params);

		logger.debug("-----请求参数-----：" + jsonObject.toJSONString());

		String result = HttpHelper.post(requestUrl, params);

		logger.debug("-----响应报文-----：" + result);

		if (null != result && !result.isEmpty()) {
			try {
				JSONObject object = JSONObject.parseObject(result);
				if (object.containsKey("returnCode") && "SUCCESS".equals(object.getString("returnCode"))) {
					if (object.containsKey("returnData") && CodeHelper.isNotNullOrEmpty(object.getString("returnData"))) {
						String returnData = object.getString("returnData");

						String returnValue = DesEncryptHelper.decryption(returnData, "c50f1d4657014620a004fc96e295451b");

						logger.debug("-----响应内容-----：" + returnValue);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
