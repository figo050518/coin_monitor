package com.chelp.oop.sys;


import com.chelp.oop.dao.coins.CoinInfoDao;
import com.chelp.oop.service.coins.CoinInfoService;
import com.chelp.oop.service.coins.CoinMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = false)
@Lazy(false)
public class CoinInfoTaskService {
	
	@Autowired
	private CoinInfoDao coininfoDao;
	@Autowired
	private CoinInfoService coinInfoService;
	@Autowired
	private CoinMonitorService coinMonitorService;
	@Transactional(readOnly = false)
	@Scheduled(cron ="* 1 * * * ?" )
	public void OtcBtcCoinInfoMonitor() throws  Exception{
		String price = coinMonitorService.OtcBtcAEMonitor();
		coinInfoService.updateAEPriceByType("1",price);
	}

	


}
