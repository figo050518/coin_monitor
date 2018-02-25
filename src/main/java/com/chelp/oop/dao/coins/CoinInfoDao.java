package com.chelp.oop.dao.coins;

import com.chelp.core.dao.IBaseDao;
import com.chelp.oop.bean.coins.CoinInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Past;

/**
 * 用户信息
 * @author Administrator
 *
 */
@Repository
@SuppressWarnings("rawtypes") 
public interface CoinInfoDao extends IBaseDao<CoinInfo> {


    CoinInfo getByType(@Param("name") String name, @Param("type")String type);
}
