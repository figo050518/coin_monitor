package com.chelp.oop.service.coins;

import com.chelp.core.service.IBaseService;



public interface CoinInfoService extends IBaseService {


    /**
     * 根据交易所 更新AE 价格
     * @param type
     * @param price
     */
    void updateAEPriceByType(String type,String price);
}
