package com.aishangxuejie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

/**
 * @author: Cuigm
 * @ClassName:  CallBaBa
 * @Description: 注解 默认值
 * @date: 2019年8月27日下午5:15:03
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Document
public @interface CallBaBa {
	
	 String value() default "叫爸爸";
}
