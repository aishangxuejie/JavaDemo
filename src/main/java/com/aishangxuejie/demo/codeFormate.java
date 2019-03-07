package com.aishangxuejie.demo;

/**
 * @author CuiGM
 * @date 2018年7月27日 下午5:30:48
 * @param name
 * @param pathName
 */
public class codeFormate {

	public static void main(String[] args) {
		String s = "aab001,aac001,aac004,aac003,aac002,\r\n" + 
				"		aab004,   alc021,   alc022,   \r\n" + 
				"		alc020,   alc023,   ldch.aae011,\r\n" + 
				"		aae036,    akb001,\r\n" + 
				"		akb002,   akb003,akb004,aab301, \r\n" + 
				"		aka130,aaeb05,alc199,alc024,alc026,   aka030,clc006,\r\n" + 
				"		blc106,alc082,alc083,alc084,aab200,aab300,aaea06,aaeb06, clc001 ";
		String ss = s.trim().replace("\r\n", "");
		System.out.println(ss);
		String [] sss = ss.split(",");
		for (String str : sss) {
			System.out.println(str.toString());
			
		}
	}
}
