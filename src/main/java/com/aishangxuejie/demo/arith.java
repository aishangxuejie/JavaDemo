package com.aishangxuejie.demo;

import java.math.BigDecimal;

public class arith {
	public static void main(String[] args) {
		//java中的“/”、“%”运算，其中前者为取整，后者取余数
		double n = 33/5;
		double m = 33%5;
		System.out.println(n+"\n"+m);
		BigDecimal o = new BigDecimal("0");
		BigDecimal x = new BigDecimal("84532.2");
		BigDecimal y = new BigDecimal("1514772.83");
		o= x.divide(y,2,4).multiply(new BigDecimal("100"));
		Integer io = o.intValue();
		System.out.println(io);
	}

}
