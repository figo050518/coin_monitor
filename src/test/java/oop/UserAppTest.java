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

public class UserAppTest {
	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(UserAppTest.class);

		String params = "source=app&version=1&token="
				+ "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0OTY2Mjk2ODAsInN1YiI6IntcInVzZXJJZFwiOlwiMVwiLFwicm9sZUlkXCI6XCJ0aGlua2dlbVwifSIsImV4cCI6MTQ5NjcxNjA4MH0.ebJ2XF1e5AAYCqhXzQkHCLoAmB6g0CFMOIS7pVfh7II"
				+ "&requestData=";

		JSONObject jsonObject = new JSONObject(true);

		// 登录
		String requestUrl = "http://192.168.1.48:18080/oop/common/api/login";
		UserParamsUtils.buildLoginParams(jsonObject);

		// 首页
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/index";
		// UserParamsUtils.buildAppIndexParams(jsonObject);

		// 统计-我的充电
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/overview";
		// UserParamsUtils.buildAppOverviewParams(jsonObject);

		// 个人中心-我的充电
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/personalCenter";
		// UserParamsUtils.buildAppPersonalCenterParams(jsonObject);

		// 个人中心-我的充电-我的员工
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/myStaff";
		// UserParamsUtils.buildAppMyStaffParams(jsonObject);

		// 个人中心-我的充电-我的员工-员工流水
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/myStaffFlow";
		// UserParamsUtils.buildAppMyStaffFlowParams(jsonObject);

		// 个人中心-我的充电-我的机构
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/myCompany";
		// UserParamsUtils.buildAppMyCompanyParams(jsonObject);

		// 个人中心-我的充电-我的机构-机构流水
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/myCompanyFlow";
		// UserParamsUtils.buildAppMyCompanyFlowParams(jsonObject);

		// 订单中心-我的充电-正在充电
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/process";
		// UserParamsUtils.buildAppProcessParams(jsonObject);

		// 订单中心-我的充电-充电记录
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/chargeRecord";
		// UserParamsUtils.buildAppChargeRecordParams(jsonObject);

		// 个人中心-我的钱包
		// String requestUrl = "http://192.168.1.48:18080/oop/app/user/api/myWallet";
		// UserParamsUtils.buildAppmyWallet(jsonObject);

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
