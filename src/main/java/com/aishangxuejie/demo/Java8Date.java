package com.aishangxuejie.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * @author: Cuigm
 * @ClassName:  Java8Date
 * @Description: TODO
 * @date: 2019年2月22日上午8:44:09
 */
public class Java8Date {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public void DateTimeFormatter() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");
		LocalDate date= LocalDate.parse("2019-3-21 08:54:51", df);
		System.out.println(date);
		System.out.println(df.format(LocalDate.now()));
		System.out.println(new Date().getTime());
		System.out.println(LocalDate.now().toString());
	}
	
	@Test
	public void test() throws InterruptedException {
		
		ExecutorService es = Executors.newFixedThreadPool(100);
		for(int i=10;i<20;i++) {
			es.execute(()->{
				for(int j=0;j<10;j++) {
					try {
						System.out.println(df.format(LocalDateTime.now()));
//						System.out.println(df.format(LocalDateTime.now()));
//						System.out.println(sdf.parse("2019-3-21 08:54:51"));
//						System.out.println(sdf.format(new Date()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		es.shutdown();
		es.awaitTermination(1, TimeUnit.DAYS);
	}
	
	
	@Test
	public void test1() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("yyyy-MM-dd HH:mm:ss".length());
		ZonedDateTime zdt = LocalDateTime.from(dtf.parse("2020-02-20 16:47:32")).atZone(ZoneId.systemDefault());
		Date a = Date.from(zdt.toInstant());
		System.out.println(a);
		
	}
}
