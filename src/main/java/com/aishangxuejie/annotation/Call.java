package com.aishangxuejie.annotation;

/**
 * @author: Cuigm
 * @ClassName:  call
 * @Description: 注解对象
 * @date: 2019年8月28日上午11:10:38
 */
public class Call {

	@CallBaBa
	private String say;
	@CallBaBa("叫爹")
	private String who;

	public String getSay() {
		return say;
	}

	public void setSay(String say) {
		this.say = say;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}
	
	
}
