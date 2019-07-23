package com.aishangxuejie.demo;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

/**
 * @author: Cuigm
 * @ClassName: CodeByte
 * @Description:  测试不同字符集编码中，字符所占字节长度
 * @date: 2019年7月23日下午2:44:20
 */
public class CodeByte {

	@Test
	public void printByteLength(String charsetName) {
		String[] charsetNames = { "UTF-8", "UTF-16", "UTF-16BE", "UTF-16LE", "UTF-32", "UTF-32BE", "UTF-32LE",
				"UNICODE", "GBK", "GB2312", "GB18030", "ISO8859-1", "BIG5", "ASCII" };
		for (int i = 0; i < charsetNames.length; i++) {
			printByteLength(charsetNames[i]);
		}
		String en = "a";
		// 一个英文字符
		String zh = "啊";
		// 一个中文字符
		try {
			System.out.println(charsetName + "编码英文字符所占字节数:" + en.getBytes(charsetName).length);
			System.out.println(charsetName + "编码中文字符所占字节数:" + zh.getBytes(charsetName).length);
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.println("非法编码格式!");
		}
	}
}
