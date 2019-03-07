package com.aishangxuejie;

import org.junit.Test;

import com.aishangxuejie.java.readproperties;

/**
 * @author: Cuigm
 * @ClassName:  pstest
 * @Description: TODO
 * @date: 2019年3月1日上午9:40:23
 */
public class pstest {

	@Test
	public void captchaProducer(){
		readproperties rp = new readproperties();
		System.out.println(rp.IP);
	}
}
