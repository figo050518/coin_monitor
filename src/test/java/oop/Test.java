package oop;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.chelp.core.exception.EncryptException;
import com.chelp.core.utils.CodeHelper;
import com.chelp.core.utils.DesEncryptHelper;
import com.chelp.core.utils.HttpHelper;
import com.google.common.collect.Maps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	public static void main(String[] args) throws Exception {
		Logger logger = LoggerFactory.getLogger(Test.class);
		String returnValue = DesEncryptHelper.decryption("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\n" +
				"+MY+E6YhDMU80TL1/XH1Gvy54zhsGg==", "c50f1d4657014620a004fc96e295451b");

		logger.debug("-----响应内容-----：" + returnValue);
//		class A{
//			private String name;
//			public String getName() {
//				return name;
//			}
//
//			public void setName(String name) {
//				this.name = name;
//			}
//		}
//		A a = new A();
//		a.setName("123");
//		Map<String,Object> map = Maps.newHashMap();
//		map.put("a",a);
//		a.setName("456");
//		System.out.print(map.get("a"));
//
//		StringBuffer a =new StringBuffer();
//		a.append("123");
//		Map<String,Object> map = Maps.newHashMap();
//		map.put("a",a);
//		a.append("456");
//		System.out.print(map.get("a"));
//
////		String requestUrl = "http://192.168.1.12:9090/oop/role/api/add";
//		String requestUrl = "http://192.168.1.12:9090/oop/role/api/update";
//		String params = "source=web&version=1&requestData=";
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("type", "2");
//
//		try {
//			params += URLEncoder.encode(DesEncryptHelper.encryption(jsonObject.toJSONString(), "c50f1d4657014620a004fc96e295451b"), "UTF-8");
//		} catch (EncryptException e1) {
//			e1.printStackTrace();
//		}
//
//		System.out.println("----请求参数-----：" + params);
//
//		String result = HttpHelper.post(requestUrl, params);
//
//		System.out.println("-----接口返回-----：" + result);
//
//		if (null != result && !result.isEmpty()) {
//			try {
//				JSONObject object = JSONObject.parseObject(result);
//				if (object.containsKey("returnCode") && "SUCCESS".equals(object.getString("returnCode"))) {
//					if (object.containsKey("returnData") && CodeHelper.isNotNullOrEmpty(object.getString("returnData"))) {
//						String returnData = object.getString("returnData");
//
//						String returnValue = DesEncryptHelper.decryption(returnData, "c50f1d4657014620a004fc96e295451b");
//
//						System.out.println("-----返回内容-----：" + returnValue);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
}
