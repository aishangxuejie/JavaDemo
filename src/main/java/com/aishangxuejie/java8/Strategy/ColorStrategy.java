package com.aishangxuejie.java8.Strategy;

public class ColorStrategy implements Strategy {

	@Override
	public boolean test(Apple apple) {
		return apple.getColor().equals(Color.GREEN);
	}

}
