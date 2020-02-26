package com.aishangxuejie.java8.Strategy;

import lombok.Data;

@Data
public class Apple {
	 private int weight;
	 private Color color;
	 
	 
	 Apple(int weight,Color color){
		 this.weight = weight; 
		 this.color = color;
	 }
	 
}
