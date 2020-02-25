package com.aishangxuejie.java8;

public class Something {

	//构造方法
	Something(){}
	
	//含参构造方法
	Something(String something) {
		System.out.println(something);
    }
	
	static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
	
	String endWith(String s) {
		return String.valueOf(s.charAt(s.length()-1));
	}
	
	void endWith() {}
}
