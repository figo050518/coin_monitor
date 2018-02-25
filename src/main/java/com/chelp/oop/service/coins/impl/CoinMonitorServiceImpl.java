package com.chelp.oop.service.coins.impl;

import com.chelp.core.service.impl.BaseServiceImpl;
import com.chelp.oop.dao.coins.CoinInfoDao;
import com.chelp.oop.service.coins.CoinInfoService;
import com.chelp.oop.service.coins.CoinMonitorService;
import com.chelp.oop.utils.JsonMapper;
import com.google.common.collect.Maps;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;


@Service
public class CoinMonitorServiceImpl extends BaseServiceImpl implements CoinMonitorService {

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(CoinMonitorServiceImpl.class);

	/**
	 * 获取 otcbtc 最低出售价格
	 * @return
	 */
	@Override
	public String OtcBtcAEMonitor() {
		Connection con = Jsoup.connect("https://otcbtc.com/sell_offers?utf8=%E2%9C%93&currency=ae&fiat_currency=cny&amount=&payment_type=all&commit=%E6%90%9C%E7%B4%A2%E5%85%91%E6%8D%A2");
		//请求头设置，特别是cookie设置
		con.header("Accept", "text/html, application/xhtml+xml, */*");
		con.header("Content-Type", "application/x-www-form-urlencoded");
		con.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0))");
		con.header("Cookie", null);
		//解析请求结果
		Document doc= null;
		try {
			doc = con.get();
			Elements s  =doc.getElementsByClass("recommend-card__price");
			String price = s.get(0).html();
			System.out.println(price);
			return price;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
