package com.aishangxuejie.demo;

/**
 * @author: Cuigm
 * @ClassName:  substring
 * @Description: TODO
 * @date: 2019年8月21日下午3:14:23
 */
public class substring {
	public static void main(String[] args) {
		String aac002 = "13032319830102621X";
		String name = "王海鸥"+aac002.substring(aac002.length()-4,aac002.length());
		System.out.println();
		
		String s = "{\"aae036\":\"2019年08月20日\",\"recevier_name\":\"董惠\",\"aac003\":\"王海鸥\",\"business_type_name\":\"继续治疗申请\"}";
		System.out.println(s.replace("王海鸥", name));
	}
}
