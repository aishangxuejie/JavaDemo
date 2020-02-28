package com.aishangxuejie.demo;

import org.junit.Test;

/**
 * @author: Cuigm
 * @ClassName:  MS
 * @Description: TODO
 * @date: 2019年3月22日上午8:32:29
 */
public class MS {
	/**
	 * 面试题，100块钱。公鸡5块钱一只。母鸡3块钱一只。小鸡1块钱3只。把100块刚好花完。怎么分配。用java写。
	 * 
	 */

	@Test
	public void maiji() {
		int gj;
		int mj;
		int xj;
		int count = 1;
		for(gj=0;gj<=20;gj++) {
			for(mj=0;mj<=33;mj++) {
				for(xj=0;xj<=300-mj-gj;xj+=3) {
					if(100 == mj*3+gj*5+xj/3) {
						count++;
						System.out.printf(count+"公鸡：%s;母鸡：%s;小鸡：%s\n",gj,mj,xj);
					}
				}
			}
		}
		System.out.println("end");
	}
	
	
	
}
