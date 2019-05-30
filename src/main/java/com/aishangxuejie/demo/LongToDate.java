package com.aishangxuejie.demo;

import java.util.Date;

/**
 * @author: Cuigm
 * @ClassName:  LongToDate
 * @Description: TODO
 * @date: 2019年5月22日上午11:34:29
 */
public class LongToDate {

	public static void main(String[] args) {
		Date a = new Date(Long.parseLong("1558454400000"));
		System.out.println(a);
	}
}
