package com.aishangxuejie;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

/**
 * @author: Cuigm
 * @ClassName:  pstest
 * @Description: TODO
 * @date: 2019年3月1日上午9:40:23
 */
@Log4j2
public class pstest {

	@Test
	public void captchaProducer(){
		int i= 10;
		int j= 10;
		log.error(i++);
		log.error(++j);
	}
}
