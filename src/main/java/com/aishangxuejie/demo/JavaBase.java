package com.aishangxuejie.demo;

class Dog {
	int age;
	String hobby = new String();
}
public class JavaBase {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.age = 3;
		dog.hobby = "吃骨头！";
		System.out.println("实例化Dog类并赋值！狗狗今年"+dog.age+"岁啦，爱好"+dog.hobby);
	}
	
}

/*
	Java基础白话文_类，对象为什么要实例化？main(String[] args)为什么要这么写？
	
	YOU：你这有啥意义？大家不在乎你几岁，爱吃啥！
	DOG：好吧，就让狗狗实力分析一波这段代码。
	YOU：请开始你的表演！！！
	package 包名（com.aishangxuejie.demo）;	-- 这东西到底有什么用？

	class 类名（Dog） {	-- class类在运行时起到什么作用？
		属性（
			int age;	-- 它凭啥不能实例化，只需要声明？
			String hobby;	-- 那hobby能实例化吗？String hobby = new String();
		）
		方法（
		
		）
	}
	public class JavaBase {
		-- 使用JAVA这么久了，你知道main方法的参数是什么吗？不写或者写其他的行么?
		public static void main(String[] args) {	
			Dog dog = new Dog();	--为什么必须要实例化？而基本类型不能实例化？
			dog.age = 3;
			dog.hobby = "吃骨头！";
			System.out.println("实例化Dog对象并赋值！狗狗今年"+dog.age+"岁啦，最大的爱好是"+dog.hobby);
		}
	}
	DOG:其实，这些疑问是我的小女票问的，她初学JAVA,遇到的问题我竟然都没深究过。（想当初初学JAVA，你爱啥啥，抄起键盘就是一顿撸。）
		当时的话，我是想想竭力解释一番，维护下我身为高贵种族程序猿的尊严。（那时真的不知道啊，当时思考的浅，并没在意。所有人告诉我的就是就是这么写！）
		但越解释越难受，各种坑填不上，问的我一时语塞。（最终被崩溃的女票狠狠鄙视了一番---你特么是个假程序猿！！！）
		(´╥ω╥`)无语凝噎~~~（我是谁？JAVA是什么？我一定是个假的JAVA程序猿。）
		
	YOU：你在这虐单身狗呢？老子要撤了~~~
	DOG：英雄留步啊！小弟学识才浅，还请赐教！
	.
	...
	.....
	哇，走啦？这么不给面子啊！那好吧，自己挖的坑，说啥也得填上！下面做出解释！
	万物皆对象；
	1、首先说包名的作用。
		Java开发过程中会产生大量的类文件，此时包机制就起到了管理组织的作用。不明白就可以想想摘苹果。苹果比作类，那我想要某一个个苹果，我需要找到对应的枝干。
	这里的枝干就是包的作用。
	2、class类作用。
		在Java中，当我们编写一个类，经由JVM编译完成后，在生成的.class文件，就会产生一个Class对象，用于表示这个类的类型信息。
	3、基本数据类型不能实例化？
		JVM已经给它们一家人赋予了初始值，不劳大家费心了。所以基本数据类型不需要实例化，但可以给他重新赋予初始值。所以String是可以滴。
	4、JAVA main(String[] args)方法，为啥要这么写，这个参数是啥？不写行不？
		首先Java Application 是必须有main方法的。这个main(String[] args)函数JVM已经垄断了。就像你的名字，少写一个字还是你吗？
	虽然main函数不是JVM的名字，但它是入口函数。如果你不写参数，是运行不了滴。不信可以试试。
		那args可以传参数吗？答案是肯定的。不信你去百度！至于如何给args赋值，有两种方式。一种是CMD命令执行，直接加上参数；二是在IDE(我用的eclipse)
	中run as-->run Confications...-->找到 program arguments,输入你想传入的值就好了。（单元单词没拼写错）
	5、对象为什么要实例化？
		很明显，大家都知道对象要实例化，那什么时候需要实例化？
		书上说类的初始化时机为“initialize on first active use”，即“在首次主动使用时初始化”。（对象就叫实例化，好吧，大家都这么叫，你不要搞事情）
		书上说对象实例化有两种方法，显示对象创建和隐式对象创建；显示就是new,太常见了，不罗嗦了。
		为什么要实例化？创建对象的目的就是操作对象。而实例化过程就是JVM为这个对象分配内存空间。这样这个对象才有存在的意义。
	6、JVM初始化顺序
		大概就是这么个优先级的顺序：静态属性=静态代码块> 非静态属性 = 构造块> 构造方法
*/