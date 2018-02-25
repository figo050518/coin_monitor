
package com.chelp.core.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * 
 * @ClassName: ThreadPoolHelper 
 * @Description: 线程池工具类
 * @author jiangjun
 * @date 2017年3月7日 下午3:10:17
 */
public class ThreadPoolHelper {
	
	private ThreadPoolHelper() {
	}

	public static final ThreadPoolExecutor SAVE_EXECUTOR = new ThreadPoolExecutor(10, 100, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
			new BasicThreadFactory.Builder().daemon(true).namingPattern("HS-SaveMsg-Handler-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());
}
