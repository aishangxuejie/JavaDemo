package com.aishangxuejie.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: Cuigm
 * @ClassName:  Java8Date
 * @Description: TODO
 * @date: 2019年2月22日上午8:44:09
 */
public class Java8Date {


	public static void main(String[] args) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMM");
		
		System.out.println(df.format(LocalDate.now()));
		System.out.println(new Date().getTime());
		
		System.out.println(LocalDate.now().toString());
	}
}
