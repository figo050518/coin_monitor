package com.chelp.oop.interceptor;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.chelp.oop.annotation.DataSource;

public class DynamicDataSourceAspect {

	/**
	 * 
	 * @Title: setDataSourceBeforeMethodExecution 
	 * @Description: 方法调用之前设置数据源
	 * @param @param point
	 * @return void
	 * @throws
	 */
	public void setDataSourceBeforeMethodExecution(JoinPoint point) {
		Class<?> target = point.getTarget().getClass();
		MethodSignature signature = (MethodSignature) point.getSignature();
		String dataSourceKey = null;
		// 优先从基类中取注解
		for (Class<?> clazz : target.getInterfaces()) {
			dataSourceKey = determineDataSource(clazz, signature.getMethod());
		}
		dataSourceKey = determineDataSource(target, signature.getMethod());
		if (null != dataSourceKey) {
			DynamicDataSourceHolder.setDataSource(dataSourceKey);
		}
	}

	/**
	 * 
	 * @Title: determineDataSource 
	 * @Description: 获取类或方法上的@DataSource注解，返回数据源key
	 * @param @param clazz
	 * @param @param method
	 * @param @return
	 * @return String
	 * @throws
	 */
	private String determineDataSource(Class<?> clazz, Method method) {
		String dataSourceKey = null;
		try {
			Class<?>[] types = method.getParameterTypes();
			// 默认使用类上面的注解
			if (clazz.isAnnotationPresent(DataSource.class)) {
				DataSource source = clazz.getAnnotation(DataSource.class);
				dataSourceKey = source.value();
			}
			// 如果方法上面有注解，则覆盖类上面的注解
			Method m = clazz.getMethod(method.getName(), types);
			if (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource dataSource = m.getAnnotation(DataSource.class);
				dataSourceKey = dataSource.value();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSourceKey;
	}

	/**
	 * 
	 * @Title: restoreDataSourceAfterMethodExecution 
	 * @Description: 方法执行完毕之后，清除当前线程数据源
	 * @param 
	 * @return void
	 * @throws
	 */
	public void restoreDataSourceAfterMethodExecution() {
		DynamicDataSourceHolder.clearDataSource();
	}
}
