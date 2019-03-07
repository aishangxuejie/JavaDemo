package com.aishangxuejie.demo;

public class SuperThisDistinction {
	public static void main(String[] args) {
		System.out.println("super() and this() ,Which difference ？");
		son son = new son();
	}
}
//父类
class father{
	private int age;
	private double hight;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHight() {
		return hight;
	}
	public void setHight(double hight) {
		this.hight = hight;
	}
	father(){
		System.out.println("I'm your DAd!");
	}
	father(int age){
		System.out.println("Your father is "+age+" years old!");
	}
	father(int age,double hight){
		System.out.println("Your father is "+age+" years old and "+hight+"m hight!");
	}
}
//子类
class son extends father {
	son(){
		//super(54);
		//super(54,1.8);
		System.out.println("I'm your Son!");
	}
}

//kownledge point
/**
	1. super关键字在子类构造函数中调用父类的构造函数时使用，且必须写在构造函数内首行。
	2. 子类构造函数中没有super()函数时，编译器会默认帮我们添加一个无参数的super(),称为隐式调用。
	3. 当父类中包含多个构造函数时，super(54)会调用相应构造函数，称为显示调用。
	4. 调用的意义是因为，如果子类使用父类构造函数，必须先初始化父类构造函数（分配内存空间），否则会调用异常。
*/