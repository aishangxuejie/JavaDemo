package com.aishangxuejie.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author: Cuigm
 * @ClassName:  Clanda
 * @Description: TODO
 * @date: 2019年4月16日下午4:57:07
 */
public class CalendarTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse("2019-03-23"));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse("2019-03-23"));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);// 自己算的
		System.out.println(between_days);
	}
}
