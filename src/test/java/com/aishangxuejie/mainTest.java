package com.aishangxuejie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @author: Cuigm
 * @ClassName:  maintest
 * @Description: TODO
 * @date: 2019年1月31日下午2:07:29
 */
public class mainTest {

	/**
	 * @Author: Cuigm
	 * @Title: mainTest   
	 * @Description: TODO  why can't use ArrayList methords 'remove'?
	 * @param:   
	 * @throws
	 */
	@Test
	public void listTest() {
		// TODO Auto-generated constructor stub
		List<String> strl = new ArrayList<>();
		strl.add("1");
		strl.add("2");
		for (String string : strl) {
			//remove 1 and 2 for see result
			if("2".equals(string)){
				strl.remove(string);//remove 2 will throw exception!
			}
		}
		for (String string : strl) {
			System.out.println(string);
		}
	}
	@Test
	public void iteratorTest() {
		// TODO Auto-generated constructor stub
		List<String> strl = new ArrayList<>();
		strl.add("1");
		strl.add("2");
		Iterator<String> stri = strl.iterator();
		//remove 1 and 2 for see result
		while (stri.hasNext()) {
			if("2".equals(stri.next())){
				stri.remove();
			}
		}
		for (String string : strl) {
			System.out.println(string);
		}
	}
}
