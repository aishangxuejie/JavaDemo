package com.aishangxuejie.demo;

class Value {
	int i;
}
public class Equivalence {
	public static void main(String[] args) {
		
		Value m1 = new Value();
		Value m2 = new Value();
		m1.i = m2.i = 1;
		System.out.println(m1.equals(m2));//c =?
	}
	
//	public static void main(String[] args) {
//		Integer n1 = new Integer(47);
//		Integer n2 = new Integer(47);
//		//true or false ?
//		System.out.println(n1 == n2);//A =?
//		System.out.println(n1 != n2);//B =?
//	

//	}
}
