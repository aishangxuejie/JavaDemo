package com.aishangxuejie.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author: Cuigm
 * @ClassName:  Executor
 * @Description: TODO
 * @date: 2019年3月21日上午9:33:38
 */
public class Executor {
	/**
	 * 	a. 每次new Thread新建对象性能差。
		b. 线程缺乏统一管理，可能无限制新建线程，相互之间竞争，及可能占用过多系统资源导致死机或oom。
		c. 缺乏更多功能，如定时执行、定期执行、线程中断。
		--- 相比new Thread，Java提供的四种线程池的好处在于：
		a. 重用存在的线程，减少对象创建、消亡的开销，性能佳。
		b. 可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞。
		c. 提供定时执行、定期执行、单线程、并发数控制等功能。
		
	 *
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        // TODO Auto-generated method stub
		    }
		}).start();
	}
	
//	ExecutorService pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	
	ExecutorService Cached = Executors.newCachedThreadPool();
	ExecutorService Cached_F = Executors.newCachedThreadPool(new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			// TODO Auto-generated method stub
			return null;
		}
	});
	ExecutorService Fixed = Executors.newFixedThreadPool(10);
	ExecutorService Fixed_F = Executors.newFixedThreadPool(10, new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			// TODO Auto-generated method stub
			return null;
		}
	});
	ExecutorService Single = Executors.newSingleThreadExecutor();
	ExecutorService Single_F = Executors.newSingleThreadExecutor(new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			// TODO Auto-generated method stub
			return null;
		}
	});
	ExecutorService Scheduled = Executors.newScheduledThreadPool(10);
	ExecutorService Scheduled_F = Executors.newScheduledThreadPool(10, new ThreadFactory() {
		
		@Override
		public Thread newThread(Runnable r) {
			// TODO Auto-generated method stub
			return null;
		}
	});
	
}
