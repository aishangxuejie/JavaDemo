package com.aishangxuejie.java8;

import java.util.function.Predicate;

import org.junit.Test;

public class testjava8 {

	@Test
	public void test() {
		//
		/*
		Converter<String, Integer> converter_01 = new Converter<String, Integer>() {
			
			@Override
			public Integer convert(String from_01) {
				// TODO Auto-generated method stub
				return Integer.valueOf(from_01);
			}
		};
		Integer converted_01 = converter_01.convert("2020");
		System.out.println("java8 之前的写法--》"+converted_01);
		*/
		
		//java8 
		/*
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("2020");
		System.out.println("java8 的常规写法--》"+converted);    // 2020
		
		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("2020");
		System.out.println(converted);   // 2020
		*/
		/*
		Converter<String, String> converter = Something::startsWith;
		String converted = converter.convert("Java");
		System.out.println(converted);    // "J"
		*/
		/*在 Lambda 表达式当中:
			1，可以直接访问外层局部变量。但不可以修改。
			2，外层局部变量(eg:num)必须不可被后面的代码修改（即隐性的具有final的语义）。
			3，lambda表达式的局部变量（eg:num）可以不用声明为final。
			4，lambda表达式的局部变量不能与局部外变量名重复。
			5，lambda表达式的内部变量可读可写。
		*/
		/*int num = 1;
		Converter<Integer, String> converter = 
				s -> String.valueOf(s+ num);
		converter.convert(2);*/
		/*
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("JAVA8 ", "Lamabda");
		System.out.println(person.firstName+person.lastName);
		
		PersonFactory<Person> personFactory1 = new PersonFactory<Person>() {
			
			@Override
			public Person create(String firstName, String lastName) {
				Person p = new Person();
				p.firstName =firstName;
				p.lastName = lastName;
				return p;
			}
		};
		Person pe = personFactory1.create("Java ", "Old");
		System.out.println(pe.firstName+pe.lastName);
		 */
		
	}
}
