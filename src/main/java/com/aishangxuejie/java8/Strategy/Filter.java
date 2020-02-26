package com.aishangxuejie.java8.Strategy;

import java.util.List;

public class Filter {
	
	private Strategy strategy;
	
	public Filter(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void excute(List<Apple> apple) {
		for (Apple apple2 : apple) {
			if(strategy.test(apple2)) {
				System.out.print(apple2);
			}
		}
	}

}
