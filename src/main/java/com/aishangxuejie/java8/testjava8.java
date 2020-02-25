package com.aishangxuejie.java8;

import org.junit.Test;

public class testjava8 {

	@Test
	public void test() {
		//
		/*
		Converter<String, Integer> converter_01 = new Converter<String, Integer>() {
			
			@Override
			public Integer convert(String from_01) {
				// TODO Auto-generated method stub
				return Integer.valueOf(from_01);
			}
		};
		Integer converted_01 = converter_01.convert("2020");
		System.out.println("java8 之前的写法--》"+converted_01);
		*/
		
		//java8 
		/*
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("2020");
		System.out.println("java8 的常规写法--》"+converted);    // 2020
		
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("2020");
		System.out.println(converted);   // 2020
		*/
		Converter<String, String> converter = Something::startsWith;
		String converted = converter.convert("Java");
		System.out.println(converted);    // "J"
	}
}
