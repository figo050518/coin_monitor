package com.chelp.core.dao;

import java.util.List;
import java.util.Map;

import com.chelp.core.bean.BaseBean;

/**
 * 
 * @ClassName: IBaseDao 
 * @Description: 基础Dao
 * @author jiangjun
 * @date 2017年4月13日 下午4:17:07
 */
public interface IBaseDao<T extends BaseBean> {

	T findObject();

	T findObject(Integer id);

	T findObject(String selectKey);

	T findObject(Map<String, Object> params);

	T findObject(T entity);

	List<T> findList();

	List<T> findList(Integer id);
	
	List<T> findList(String selectKey);

	List<T> findList(T entity);

	List<T> findList(Map<String, Object> params);

	int countListByPagination();

	int countListByPagination(Integer id);

	int countListByPagination(T entity);

	int countListByPagination(Map<String, Object> params);

	int insert(T entity);

	int update(T entity);

	int delete(Integer id);

	int delete(T entity);
}
