package com.chelp.oop.service.coins.impl;

import com.chelp.core.service.impl.BaseServiceImpl;
import com.chelp.oop.bean.coins.CoinInfo;
import com.chelp.oop.dao.coins.CoinInfoDao;
import com.chelp.oop.service.coins.CoinInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CoinInfoServiceImpl extends BaseServiceImpl implements CoinInfoService {
	

	@Autowired
	private CoinInfoDao coinInfoDao;

	@Override
	public void updateAEPriceByType(String type,String price) {
		CoinInfo coinInfo =coinInfoDao.getByType("AE",type);
		if(coinInfo==null){
			CoinInfo c = new CoinInfo();
			c.setName("AE");
			c.setType(type);
			c.setUpdateDate(new Date());
			c.setSellPrice(price);
			coinInfoDao.insert(c);
		}else{
			coinInfo.setSellPrice(price);
			coinInfo.setUpdateDate(new Date());
			coinInfoDao.update(coinInfo);
		}
	}
}
