package com.aishangxuejie.demo;

public class strSplit {

	/**
	 * �����ʽ�ַ������ָ��� ��ʽ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "T90.201,S02.102,S02.600,S05.802,S42.100,T14.400,G51.301,H93.100,H90.000,";
		formatStr(str);

	}

	public static void formatStr(String str) {
		String[] strArray = str.split(",");
		int s = str.length();
		int ss = str.lastIndexOf(str);
		int strL = strArray.length;
		System.out.println(s + "   " + strL + "    " + ss);
		
		System.out.println("���鳤�ȣ�" + strArray.length);
		int i = 0;
		for (String strArry : strArray) {
			System.out.print("��ţ�" + i + "\t" + strArry + "\n");
			i++;
		}
	}

}
