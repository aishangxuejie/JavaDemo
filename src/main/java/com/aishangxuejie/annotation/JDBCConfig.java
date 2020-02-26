package com.aishangxuejie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.mongodb.core.mapping.Document;

@Retention(RetentionPolicy.RUNTIME)
@Document
@Target(ElementType.TYPE)
@Inherited
public @interface JDBCConfig {
	
	String ip();
	int port() default 3306;
	String database();
	String username();
	String password();
}
