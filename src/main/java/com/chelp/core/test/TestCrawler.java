package com.chelp.core.test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestCrawler {

	public static void main(String[] args) throws  Exception{
		Connection con = Jsoup.connect("https://otcbtc.com/sell_offers?utf8=%E2%9C%93&currency=ae&fiat_currency=cny&amount=&payment_type=all&commit=%E6%90%9C%E7%B4%A2%E5%85%91%E6%8D%A2");
		//请求头设置，特别是cookie设置
		con.header("Accept", "text/html, application/xhtml+xml, */*");
		con.header("Content-Type", "application/x-www-form-urlencoded");
		con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
		con.header("Cookie", null);
		//解析请求结果
		Document doc=con.get();
		Elements s  =doc.getElementsByClass("recommend-card__price");
		String price = s.get(0).html();
		System.out.println(price);

		
	}
	public static String httpGet(String urlStr, Map<String, String> params) throws Exception {
	    StringBuilder sb = new StringBuilder();
	    if (null != params && params.size() > 0) {
	        sb.append("?");
	        Entry<String, String> en;
	        for (Iterator<Entry<String, String>> ir = params.entrySet().iterator(); ir.hasNext();) {
	            en = ir.next();
	            sb.append(en.getKey() + "=" + URLEncoder.encode(en.getValue(),"utf-8") + (ir.hasNext() ? "&" : ""));
	        }
	    }
	    URL url = new URL(urlStr + sb);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	    conn.setConnectTimeout(5000);
	    conn.setReadTimeout(5000);
	    conn.setRequestMethod("GET");
	    if (conn.getResponseCode() != 200)
	        throw new Exception("请求异常状态值:" + conn.getResponseCode());
	    BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	    Reader reader = new InputStreamReader(bis,"utf-8");
	    char[] buffer = new char[2048];
	    int len = 0;
	    CharArrayWriter caw = new CharArrayWriter();
	    while ((len = reader.read(buffer)) > -1)
	        caw.write(buffer, 0, len);
	    reader.close();
	    bis.close();
	    conn.disconnect();
	    //System.out.println(caw);
	    return caw.toString();
	}
}
