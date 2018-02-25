package com.chelp.oop.interceptor;

public class DynamicDataSourceHolder {

	private DynamicDataSourceHolder() {
	}

	private static final ThreadLocal<String> DATA_SOURCE_HOLDER = new ThreadLocal<String>();

	public static String getDataSource() {
		return DATA_SOURCE_HOLDER.get();
	}

	public static void setDataSource(String dataSource) {
		DATA_SOURCE_HOLDER.set(dataSource);
	}

	public static void clearDataSource() {
		DATA_SOURCE_HOLDER.remove();
	}
}
