package com.aishangxuejie.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CuiGM
 * @date 2018年6月28日 下午1:46:41
 * @param name
 * @param pathName
 */
public class zz {

	public static void main(String[] args) {
		
	      // 按指定模式在字符串查找
	      String line = "报销金额:115.00";
	      String pattern = "(\\D:)(.*)";
	 
	      // 创建 Pattern 对象
	      Pattern r = Pattern.compile(pattern);
	 
	      // 现在创建 matcher 对象
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(2) );
	      } else {
	         System.out.println("NO MATCH");
	      }
	}
}
