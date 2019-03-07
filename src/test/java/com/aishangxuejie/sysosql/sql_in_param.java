package com.aishangxuejie.sysosql;

import java.util.List;

import org.junit.Test;

/**
 * @author: Cuigm
 * @ClassName:  str
 * @Description: TODO
 * @date: 2019年2月26日下午2:59:47
 */
public class sql_in_param {
	
	/**
	 * @Author: Cuigm
	 * @Title: str_splid   
	 * @Description: TODO   
	 * @param:       
	 * @return: void  
	 * @date: 2019年2月26日下午3:00:08    
	 * @throws
	 */
	@Test
	public void str_splid() {
		// TODO Auto-generated method stub

		String ss = "14221776\r\n" + 
				"14221753\r\n" + 
				"14212544\r\n" + 
				"14212529\r\n" + 
				"14212416\r\n" + 
				"14212336\r\n" + 
				"14238033\r\n" + 
				"14187883\r\n" + 
				"14187872\r\n" + 
				"14187866\r\n" + 
				"14252535\r\n" + 
				"14042876\r\n" + 
				"13628874\r\n" + 
				"13628885\r\n" + 
				"12389205\r\n" + 
				"12389192\r\n" + 
				"12389175\r\n" + 
				"12359767\r\n" + 
				"11329518\r\n" + 
				"11523346\r\n" + 
				"9948678\r\n" + 
				"8462335\r\n" + 
				"8461785\r\n" + 
				"7806571\r\n" + 
				"7806166";
		String[] zero_str = ss.split("\\r\\n");
		StringBuffer out_str = new StringBuffer();
		for (String str : zero_str) {
			out_str.append("'").append(str).append("',");
		}
		System.out.println(out_str.toString());
	}

}
