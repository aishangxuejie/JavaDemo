package com.aishangxuejie.java;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author: Cuigm
 * @ClassName:  readproperties
 * @Description: TODO
 * @date: 2019年2月22日上午9:19:39
 */

@Data
@Component
@ConfigurationProperties(prefix = "ftp")
@PropertySource(value={"classpath:ftp.properties"}, ignoreResourceNotFound = true)
public class readproperties {
	public String USERNAME;
	public String PASSWORD;
	public String IP;
	public int PORT;
	
	/**
	 * @Author: Cuigm
	 * @Title: syso   
	 * @Description: TODO   
	 * @param:       
	 * @return: void  
	 * @date: 2019年3月1日上午9:24:19    
	 * @throws
	 */


	public static void main(String[] args){
		//JVM 配置文件
		//pps.list(System.out);
//		System.getProperty("user.dir");
//		System.out.println(System.getProperty("user.dir"));
//		System.out.println(System.getProperty("sun.desktop"));
//		System.out.println(System.getProperty("file.separator"));
//		System.out.println(System.getProperty("os.name"));
//		System.out.println(System.getProperty("os.arch"));
//		String ss = System.getProperty("file.separator");
//		String fileSeperator = File.separator;
//		System.out.println(fileSeperator);
		
	}

}
