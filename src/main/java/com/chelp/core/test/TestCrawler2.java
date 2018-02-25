package com.chelp.core.test;

import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.common.collect.Maps;

public class TestCrawler2 {

	public static void main(String[] args) {
		Map<String,String> map =Maps.newHashMap();
		map.put("loginName", "18094232453");
		map.put("password", "gzhlt1990819");
		map.put("phoneCode", "");
		map.put("type", "0");
	
		try {
			String s = httpGet("https://otcbtc.com/sell_offers",map);
			System.out.println(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String httpGet(String urlStr, Map<String, String> params) throws Exception {
		String body ="{\"coinType\":\"15\",\"tradeType\":\"0\"}";
		Connection.Response res = Jsoup.connect(
                "https://www.coinw.com/newUser/login/index.html").userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")	
				.ignoreContentType(true)
				.header("Accept", "application/json, text/javascript, */*; q=0.01").data(params)//进行模拟登陆
                .method(Connection.Method.POST).timeout(10000).execute();//设置请求时间和登陆用的用户名，密码。
		String sessionId = res.cookie("JSESSIONID");//不同网站网址的cookie不一样。而且每次访问都不一样，所以不要想着把session保存起来。
        String __jsluid = res.cookie("__jsluid");//
//        String zh_choose = res.cookie("zh_choose");
//        String username = res.cookie("username");
//        String lvt = res.cookie("Hm_lvt_525b7a4b6599566fc46ec53565d28557");
//        String lpvt = res.cookie("Hm_lpvt_525b7a4b6599566fc46ec53565d28557");
        Document objectDoc = Jsoup.connect(
                "https://www.coinw.com/newTrade/coin.html").cookie(//里面的网址(就是你想要爬取的网页)
                "JSESSIONID", sessionId).cookie("__jsluid", __jsluid).method(Connection.Method.GET).requestBody(body)
                .timeout(10000).post();//设置请求的时间(这里设置的请求时间是10秒)
        String s = objectDoc.getElementById("tradebuyprice").val();
        System.out.println(s);
       return  objectDoc .text();
	}
}
