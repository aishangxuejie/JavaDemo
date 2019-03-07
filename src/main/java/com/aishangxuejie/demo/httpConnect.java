package com.aishangxuejie.demo;

import util.HttpRequest;

public class httpConnect {

	final static String ZHUBODANMU = "https://www.panda.tv/ajax_send_group_msg";
	final static String token ="cf5065a57e4336e6f6c03b707e65b4fd";
	final static String roomid ="190075";
	final static String type ="1";
	final static String content ="2";
	final static String hostid ="23013712";
	final static String __plat ="pc_web";
	final static String topMsg ="0";
	final static String __ ="1512103139017";
	public static void main(String[] args) {
		HttpRequest.sendGet(ZHUBODANMU,"roomid="+roomid);
	}
}
