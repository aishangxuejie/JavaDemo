package com.aishangxuejie.demo;

import java.util.HashMap;
import java.util.Map;

import com.aishangxuejie.model.Md01;
import com.aishangxuejie.model.Md01Key;


/**
 * @author: Cuigm
 * @ClassName:  HashDemo
 * @Description: TODO
 * @date: 2019年5月14日上午8:57:50
 */
public class HashCodeDemo {
	
	
	static Map<Md01Key, Md01> map = new HashMap<Md01Key, Md01>(20000);
	static Map<Md01Key, String> map2 = new HashMap<Md01Key, String>(20000);
	public static void main(String[] args) {
//		one();
		two();
	}
	/**
	 * @Author: Cuigm
	 * @Title: two   
	 * @Description: TODO   
	 * @param:       
	 * @return: void  
	 * @date: 2019年5月14日上午10:45:05    
	 * @throws
	 */
	private static void two() {
		for (int i=0;i<5;i++) {
			Md01Key key = new Md01Key();
			key.setMd001("med001_"+i);
			key.setAab301("13000"+i);
			map2.put(key, "v_"+i);
		}
		Md01Key req = new Md01Key();
		req.setMd001("med001_3");
		req.setAab301("130003");
		String res = map2.get(req);
		System.out.println(res);
		
	}
	/**
	 * @Author: Cuigm
	 * @Title: one   
	 * @Description: TODO   
	 * @param:       
	 * @return: void  
	 * @date: 2019年5月14日上午10:43:45    
	 * @throws
	 */
	private static void one() {
		for (int i=0;i<5;i++) {
			Md01 md01 = new Md01();
			Md01Key key = new Md01Key();
			key.setMd001("med001_"+i);
			key.setAab301("13000"+i);
			md01.setMd002("med002_"+i);
			md01.setMd003("med003_"+i);
			map.put(key, md01);
		}
		Md01Key req = new Md01Key();
		req.setAab301("130002");
		req.setMd001("med001_2");
		Md01 res = map.get(req);
		System.out.println(res.getMd002());
	}
	
}
