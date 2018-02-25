package com.chelp.core.utils;

import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.chelp.core.common.Constants;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 
 * @ClassName: CacheHelper 
 * @Description: 缓存工具类
 * @author jiangjun
 * @date 2017年2月28日 下午2:54:00
 */
public class CacheHelper {
	
	private CacheHelper() {
	}

	public static Object get(String key) {
		return get(Constants.SYS_CACHE, key);
	}

	public static void put(String key, Object value) {
		put(Constants.SYS_CACHE, key, value);
	}

	public static void remove(String key) {
		remove(Constants.SYS_CACHE, key);
	}

	public static Object get(String cacheName, String key) {
		Element element = getCache(cacheName).get(key);
		return element == null ? null : element.getObjectValue();
	}

	public static void put(String cacheName, String key, Object value) {
		Element element = new Element(key, value);
		getCache(cacheName).put(element);
	}

	public static void remove(String cacheName, String key) {
		getCache(cacheName).remove(key);
	}

	private static Cache getCache(String cacheName) {
		EhCacheCacheManager ehCacheCacheManager = ((EhCacheCacheManager) SpringContextHolder.getBean("cacheManager"));
		CacheManager cacheManager = ehCacheCacheManager.getCacheManager();
		Cache cache = cacheManager.getCache(cacheName);
		if (cache == null) {
			cacheManager.addCache(cacheName);
			cache = cacheManager.getCache(cacheName);
			cache.getCacheConfiguration().setEternal(true);
		}
		return cache;
	}
}
