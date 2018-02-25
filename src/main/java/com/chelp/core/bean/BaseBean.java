package com.chelp.core.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: BaseBean 
 * @Description: 基础Bean
 * @author jiangjun
 * @date 2017年4月12日 下午4:11:09
 */
public abstract class BaseBean {
	
	private String token;

	/**
	 * 分页开始下标
	 */
	@JSONField(serialize = false)
	private int limitStartIndex;
	/**
	 * 分页开始下标
	 */
	@JSONField(serialize = false)
	private int pageIndex;
	/**
	 * 每页多少条数据
	 */
	@JSONField(serialize = false)
	private int pageSize;

	public int getLimitStartIndex() {
		return limitStartIndex;
	}

	public void setLimitStartIndex(int limitStartIndex) {
		this.limitStartIndex = limitStartIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
