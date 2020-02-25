package com.aishangxuejie.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class StreamTest {
	List<String> stringCo = new ArrayList<>();
	
	@Test
	public void test1(){
		stringCo.add("1");
		stringCo.add("2");
		stringCo.add("5");
		stringCo.add("3");
		stringCo.add("4");
//		stringCo.stream().filter(s -> Integer.valueOf(s)>3).forEach(System.out::print);
//		
//		stringCo.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		/*
		stringCo.add("q1");
		stringCo.add("w2");
		stringCo.add("w5");
		stringCo.add("e3");
		stringCo.add("a4");
		// 装逼这么写
		stringCo.stream().map((String s) -> s.toUpperCase()).forEach(o -> System.out.print(o));
		stringCo.stream().map(s -> s.toUpperCase()).forEach(System.out::print);
		stringCo.stream().map(String::toUpperCase).forEach(System.out::print);
		//屌丝这么写
		for (String string : stringCo) {
			System.out.println(string.toUpperCase());
		}
		*/
		// 装逼写
		long count = stringCo.stream().filter(s->Integer.valueOf(s)>3).count();
		System.out.println(count);
		//屌丝写
		int count2 = 0;
		for (String string : stringCo) {
			int s = Integer.valueOf(string);
			if(s>3) {
				count2+=1;
			}
		}
		System.out.println(count2);
	}
	
	@Test
	public void test2() {

		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		long t0 = System.nanoTime();
		//装逼写法
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		long t01 = System.nanoTime();
		//装飞机写法
		long count1 = values.parallelStream().sorted().count();
		System.out.println(count1);
		long t11 = System.nanoTime();
		long millis1 = TimeUnit.NANOSECONDS.toMillis(t11 - t01);
		System.out.println(String.format("parallel sort took: %d ms", millis1));
//		1000000
//		sequential sort took: 620 ms
//		1000000
//		parallel sort took: 292 ms
	}
	
	@Test
	public void test3() {
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
		    map.putIfAbsent(i, "val" + i);
		}
//		map.forEach((id, val) -> System.out.println(val));
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);
		System.out.println(map.get(3));
		
		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false

		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true

		map.computeIfAbsent(3, num -> "bam");
		map.get(3);             // val33
		
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);  

	}

}
