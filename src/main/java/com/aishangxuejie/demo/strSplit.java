package com.aishangxuejie.demo;

public class strSplit {

	/**
	 * �����ʽ�ַ������ָ��� ��ʽ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "T90.201,S02.102,S02.600,S05.802,S42.100,T14.400,G51.301,H93.100,H90.000,";
		String ss = "氨酚咖黄烷胺片\r\n" + 
				"氨酚美伪滴剂\r\n" + 
				"氨酚美伪麻片与苯酚伪麻片\r\n" + 
				"氨酚那敏三味浸膏胶囊\r\n" + 
				"氨酚烷胺咖敏胶囊\r\n" + 
				"氨酚烷胺那敏胶囊\r\n" + 
				"氨酚伪麻胶囊\r\n" + 
				"氨酚伪麻咀嚼片\r\n" + 
				"氨酚伪麻颗粒剂\r\n" + 
				"氨酚伪麻美芬胶囊\r\n" + 
				"氨酚伪麻美芬片\r\n" + 
				"氨酚伪麻美芬片（Ⅱ）\r\n" + 
				"氨酚伪麻美芬片（Ⅲ）\r\n" + 
				"氨酚伪麻那敏胶囊\r\n" + 
				"氨酚伪麻那敏胶囊（夜用）\r\n" + 
				"氨酚伪麻那敏咀嚼片\r\n" + 
				"氨酚伪麻那敏片\r\n" + 
				"氨酚伪麻那敏溶液\r\n" + 
				"氨酚伪麻片\r\n" + 
				"氨金黄敏颗粒\r\n" + 
				"氨咖黄敏胶囊\r\n" + 
				"氨咖黄敏口服溶液\r\n" + 
				"氨咖黄敏片\r\n" + 
				"氨咖麻敏胶囊\r\n" + 
				"氨咖愈敏溶液\r\n" + 
				"氨麻苯美片\r\n" + 
				"氨麻美敏口服溶液\r\n" + 
				"氨麻美敏片\r\n" + 
				"氨麻美敏片（Ⅱ）\r\n" + 
				"氨麻美敏片（Ⅲ）\r\n" + 
				"贝敏伪麻片\r\n" + 
				"布洛伪麻分散片\r\n" + 
				"布洛伪麻胶囊\r\n" + 
				"布洛伪麻颗粒剂\r\n" + 
				"布洛伪麻片\r\n" + 
				"酚咖麻敏胶囊\r\n" + 
				"酚咖片\r\n" + 
				"酚麻美敏胶囊\r\n" + 
				"酚麻美敏片\r\n" + 
				"酚麻美软胶囊\r\n" + 
				"酚美愈伪麻口服液\r\n" + 
				"酚明伪麻片\r\n" + 
				"复方氨酚美沙糖浆\r\n" + 
				"复方氨酚那敏颗粒\r\n" + 
				"复方氨酚葡锌片\r\n" + 
				"复方氨酚烷胺胶囊\r\n" + 
				"复方氨酚烷胺颗粒\r\n" + 
				"复方氨酚烷胺片\r\n" + 
				"复方北豆根氨酚那敏片\r\n" + 
				"复方贝母氯化铵片\r\n" + 
				"复方酚咖伪麻胶囊\r\n" + 
				"复方甘草氯化铵糖浆\r\n" + 
				"复方甘草浙贝氯化铵片\r\n" + 
				"复方氯丙那林鱼腥草素钠片\r\n" + 
				"复方枇杷氯化铵糖浆\r\n" + 
				"复方氢溴酸右美沙芬胶囊\r\n" + 
				"复方氢溴酸右美沙芬糖浆\r\n" + 
				"复方忍冬藤阿司匹林片\r\n" + 
				"复方锌布颗粒剂\r\n" + 
				"复方盐酸伪麻黄碱缓释胶囊\r\n" + 
				"复方银翘氨敏胶囊\r\n" + 
				"复方愈创木酚磺酸钾口服溶液\r\n" + 
				"复方愈酚喷托那敏糖浆\r\n" + 
				"咖酚伪麻片\r\n" + 
				"科达琳\r\n" + 
				"柳酚咖敏片\r\n" + 
				"洛芬葡锌那敏片\r\n" + 
				"美尔伪麻溶液\r\n" + 
				"美酚伪麻片\r\n" + 
				"美敏伪麻口服液\r\n" + 
				"美愈伪麻胶囊\r\n" + 
				"美愈伪麻口服溶液\r\n" + 
				"美愈伪麻口服液\r\n" + 
				"喷托维林氯化铵片\r\n" + 
				"喷托维林氯化铵糖浆\r\n" + 
				"扑尔伪麻片\r\n" + 
				"双分伪麻胶囊\r\n" + 
				"双扑伪麻分散片\r\n" + 
				"双扑伪麻胶囊\r\n" + 
				"双扑伪麻颗粒\r\n" + 
				"双扑伪麻片\r\n" + 
				"伪麻那敏胶囊\r\n" + 
				"伪麻那敏片\r\n" + 
				"右美沙芬愈创甘油醚糖浆\r\n" + 
				"愈创维林那敏片\r\n" + 
				"愈酚喷托异丙嗪颗粒\r\n" + 
				"愈酚维林片\r\n" + 
				"愈酚伪麻颗粒\r\n" + 
				"愈酚伪麻片\r\n" + 
				"愈美胶囊\r\n" + 
				"愈美颗粒剂\r\n" + 
				"愈美片\r\n" + 
				"";
		
//		formatStr(str);
		formatSs(ss);

	}

	/**
	 * @Author: Cuigm
	 * @Title: formatSs   
	 * @Description: TODO   
	 * @param: @param ss      
	 * @return: void  
	 * @date: 2019年3月28日下午1:40:50    
	 * @throws
	 */
	private static void formatSs(String ss) {
		
		System.out.print(ss.replace("\r\n", "、"));
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
