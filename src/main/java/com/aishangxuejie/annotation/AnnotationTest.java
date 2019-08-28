package com.aishangxuejie.annotation;

import java.lang.reflect.Field;

/**
 * @author: Cuigm
 * @ClassName:  annotationTest
 * @Description: 注解测试
 * @date: 2019年8月27日下午5:13:58
 */
public class AnnotationTest {
	
	public static void main(String[] args) {
		Class<?> clazz = Call.class;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(CallBaBa.class)) {
				CallBaBa cb = (CallBaBa)field.getAnnotation(CallBaBa.class);
				String cbstr = cb.value();
				System.out.println(cbstr);
			}
		}
    }
}
