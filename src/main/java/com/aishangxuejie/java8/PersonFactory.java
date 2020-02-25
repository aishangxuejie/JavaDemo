package com.aishangxuejie.java8;

@FunctionalInterface
public interface PersonFactory<P extends Person> {

	 P create(String firstName, String lastName);
	 
}
