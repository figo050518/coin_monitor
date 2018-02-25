package com.chelp.core.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.chelp.core.bean.BaseBean;
import com.chelp.core.dao.IBaseDao;
import com.chelp.core.service.IBaseCrudService;

public class BaseCrudServiceImpl<T extends BaseBean, D extends IBaseDao<T>> extends BaseServiceImpl implements IBaseCrudService<T, D> {

	@Autowired
	private D baseDao;

	@Override
	public T findObject() {
		return this.baseDao.findObject();
	}

	@Override
	public T findObject(Integer id) {
		return this.baseDao.findObject(id);
	}

	@Override
	public T findObject(String selectKey) {
		return this.baseDao.findObject(selectKey);
	}

	@Override
	public T findObject(Map<String, Object> params) {
		return this.baseDao.findObject(params);
	}

	@Override
	public T findObject(T entity) {
		return this.baseDao.findObject(entity);
	}

	@Override
	public List<T> findList() {
		return this.baseDao.findList();
	}

	@Override
	public List<T> findList(Integer id) {
		return this.baseDao.findList(id);
	}
	
	@Override
	public List<T> findList(String selectKey) {
		return this.baseDao.findList(selectKey);
	}

	@Override
	public List<T> findList(T entity) {
		return this.baseDao.findList(entity);
	}

	@Override
	public List<T> findList(Map<String, Object> params) {
		return this.baseDao.findList(params);
	}

	@Override
	public int countListByPagination() {
		return this.baseDao.countListByPagination();
	}

	@Override
	public int countListByPagination(Integer id) {
		return this.baseDao.countListByPagination(id);
	}

	@Override
	public int countListByPagination(T entity) {
		return this.baseDao.countListByPagination(entity);
	}

	@Override
	public int countListByPagination(Map<String, Object> params) {
		return this.baseDao.countListByPagination(params);
	}

	@Override
	public int insert(T entity) {
		return this.baseDao.insert(entity);
	}

	@Override
	public int update(T entity) {
		return this.baseDao.update(entity);
	}

	@Override
	public int delete(Integer id) {
		return this.baseDao.delete(id);
	}

	@Override
	public int delete(T entity) {
		return this.baseDao.delete(entity);
	}

}
