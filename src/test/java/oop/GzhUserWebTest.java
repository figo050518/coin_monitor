package oop;

import com.alibaba.fastjson.JSONObject;
import com.chelp.core.exception.EncryptException;
import com.chelp.core.utils.CodeHelper;
import com.chelp.core.utils.DesEncryptHelper;
import com.chelp.core.utils.HttpHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GzhUserWebTest {

	public static void main(String[] args) {


		Logger logger = LoggerFactory.getLogger(GzhUserWebTest.class);

		String params = "source=web&version=1&token=eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0OTUwOTMxNjgsInN1YiI6IntcInVzZXJJZFwiOlwiMVwiLFwicm9sZUlkXCI6XCJ0aGlua2dlbVwifSIsImV4cCI6MTQ5NTE3OTU2OH0.YkEZknKWsTNZ677pMQ1GVtw1Z7qcdnFQ6KDFx30_Fpo&requestData=";

		JSONObject jsonObject = new JSONObject(true);
		jsonObject.put("querys","[{'city':'南京'}]");
		jsonObject.put("loginName","0428");
		jsonObject.put("password","123456");
		jsonObject.put("remarks","备注");
		jsonObject.put("token","eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0OTUwOTMxNjgsInN1YiI6IntcInVzZXJJZFwiOlwiMVwiLFwicm9sZUlkXCI6XCJ0aGlua2dlbVwifSIsImV4cCI6MTQ5NTE3OTU2OH0.YkEZknKWsTNZ677pMQ1GVtw1Z7qcdnFQ6KDFx30_Fpo");
		// String requestUrl = "http://192.168.1.12:9099/oop/web/station/ex/api/detailStat";
		String requestUrl = "http://121.40.230.142:18080/oop/common/api/login";
		 UserParamsUtils.buildLoginParams(jsonObject);

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
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/dataByUser";
		// UserParamsUtils.buildWebDataByUserParams(jsonObject);

		// 统计分析-我的员工-按用户统计-单用户充电统计
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/dataBySingleUser";
		// UserParamsUtils.buildWebDataBySingleUserParams(jsonObject);

		// 统计分析-我的员工-按用户统计-机构用户联动
		// String requestUrl = "http://192.168.1.48:18080/oop/web/user/api/findUserByCompanyId";
		// UserParamsUtils.buildWebFindUserByCompanyIdParams(jsonObject);

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
