package com.chelp.oop.bean.coins;

import com.chelp.core.bean.BaseBean;

import java.util.Date;

/**
 * 各种币的信息
 */
public class CoinInfo extends BaseBean {

    private Integer id;

    private String name;//名称  如 AE/CNY

    private String sellPrice;

    private String buyPrice;

    private String  type;//交易所  1 OTCBTC 2 ZB 3 币赢

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}