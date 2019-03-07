package com.aishangxuejie.demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class reflection {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<OnePlus> Op = OnePlus.class;
		Field[] field = Op.getDeclaredFields();// ��ȡ����
		Method[] methods = Op.getClass().getMethods(); 
		for (Field field2 : field) {
			String name = field2.getName(); // ��ȡ���Ե�����
			String type = field2.getGenericType().toString(); // ��ȡ���Ե�����
			name = name.substring(0, 1).toUpperCase() + name.substring(1); // �����Ե����ַ���д�����㹹��get��set����
			
			if (type.equals("class java.lang.String")) {
				Method m = Op.getMethod("get" + name);
	            m = Op.getMethod("set" + name, String.class);
	            m.invoke(Op, "");
				System.out.println(name);
			}
			if(type.equals("class java.util.Date")){
				Method m = Op.getMethod("get" + name);
				Date value = (Date) m.invoke(Op);
                if (value == null) {
                    m = Op.getMethod("set" + name, String.class);
                    m.invoke(Op, "");
                }
                System.out.println(name);
			}
			if(type.equals("int")){
				Method m = Op.getMethod("get" + name);
				Integer value = (Integer) m.invoke(Op);
                if (value == null) {
                    m = Op.getMethod("set" + name, String.class);
                    m.invoke(Op, "");
                }
                System.out.println(name);
			}
		}
	}

	
	/*
	 * Method[] methods = Op.getClass().getMethods();//���� for(Method
	 * method:methods){ Class<?>[] clazz = method.getParameterTypes(); String
	 * type = clazz[0].getName(); System.out.println(type);
	 * if(type.equals("java.util.Date")){ method.invoke(Op, (Date)obj); } else
	 * if(type.equals("java.lang.Integer")){ method.invoke(Op, new
	 * Integer((String)obj)); }else{ //........ } }
	 */
}

// null���Ը�ֵ�����ñ������㲻�ܽ�null�����������ͱ���
class OnePlus {

	private String name;
	private int size;
	private Date year;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}
}