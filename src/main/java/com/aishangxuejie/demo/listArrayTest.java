package com.aishangxuejie.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author CuiGM
 * @date 2018年9月25日 上午9:37:22
 * @param name
 * @param pathName
 */
public class listArrayTest {

	public static void main(String[] args) {
		List<String> ls = setList();
		
		listArry(ls);
		setArry(ls);
		treeSetArry(ls);
		coList(ls);
	}
	private static void coList(List<String> ls) {
		long start = System.currentTimeMillis();
		Collections.sort(ls, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("Collections.sort:"+(System.currentTimeMillis()-start)+"ms");
	}
	private static void treeSetArry(List<String> ls) {
		long start = System.currentTimeMillis();
		TreeSet<String> ts = new TreeSet<>(ls);
		List<String> treeSetList = new ArrayList<String>();
		treeSetList.addAll(ts);
		System.out.println("TreeSet:"+(System.currentTimeMillis()-start)+"ms");
	}
	private static void setArry(List<String> ls) {
		long start = System.currentTimeMillis();
		Set<String> set = new HashSet<>(ls);
		List<String> setList = new ArrayList<String>();
		setList.addAll(set);
		System.out.println("Set:"+(System.currentTimeMillis()-start)+"ms");
	}
	private static void listArry(List<String> ls) {
		long start = System.currentTimeMillis();
		List<String> listTem = new ArrayList<>();
		for (String string : ls) {
			if (!ls.contains(string)) {
				listTem.add(string);
			}
		}
		System.out.println("Foreach:"+(System.currentTimeMillis()-start)+"ms");
	}
	
	public static List<String> setList() {
		List<String> list = new ArrayList<>();
		 Random rd= new Random();
		 for(int i=100000;i>0;i--) {
			 list.add("e"+rd.nextInt(100));
//			 System.out.print(rd.nextInt(100)+",");
		 }
		 return list;
	}
}
