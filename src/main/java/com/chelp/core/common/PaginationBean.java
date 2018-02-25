package com.chelp.core.common;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: PaginationBean 
 * @Description: 分页对象
 * @author jiangjun
 * @param <T>
 * @date 2017年4月13日 下午5:30:30
 */
public class PaginationBean<T> implements Serializable {

	/** 
	 * @Fields serialVersionUID : 序列号
	 */
	private static final long serialVersionUID = -5987674965905840227L;
	/**
	 * 当前页码
	 */
	private int pageIndex = 1;
	/**
	 * 每页多少条数据 
	 */
	private int pageSize = 30;
	/**
	 * 总共多少页
	 */
	private int totalPage;
	/**
	 * 总共多少条数据
	 */
	private int totalCount;
	/**
	 * 数据
	 */
	public List<T> list;

	public PaginationBean(int pageIndex, int pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	public PaginationBean(int pageIndex, int pageSize, int totalCount) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = getTotalPages();
	}

	private int getTotalPages() {
		int totalPages = 0;
		if (totalCount <= pageSize) {
			totalPages = 1;
		}
		if (totalCount % pageSize == 0) {
			totalPages = (totalCount / pageSize);
		} else {
			totalPages = (totalCount / pageSize) + 1;
		}
		return totalPages;
	}

	@JSONField(serialize = false)
	public int getLimitStartIndex() {
		int limitStartIndex =0;
		if (pageIndex > 0 ) {
			limitStartIndex = (pageIndex - 1) * pageSize;
		}
		return limitStartIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = getTotalPages();
		
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
