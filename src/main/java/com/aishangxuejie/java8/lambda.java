package com.aishangxuejie.java8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author CuiGM
 * @date 2018年10月16日 下午4:26:21
 * @param name
 * @param pathName
 */
public class lambda {

	/**
	 * Lambda 是一个匿名函数，Lambda 表达式可以理解为是一段可以传递的代码（将代码像数据一样进行传递）。
	 * 可以写出更简洁、更灵活的代码。作为一种更紧凑的代码风格，使Java的语言表达能力得到了提升。
	 * 
	 * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
	 * 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
	 * 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
	 * 
	 * Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。
	 * 在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
	 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
	 */
	public static void main(String[] args) {
		/*lambda1();
		lambda jt = new lambda();
		MathOperation addition1 = new MathOperation() {
			@Override
			public int operation(int a, int b) {
				return a + b;
			}
		};
		System.out.println("10 + 5 = " + jt.operate(5, 10, addition1));

		MathOperation addition = (int a, int b) -> a + b;
		System.out.println("10 + 5 = " + jt.operate(10, 5, addition));

		// 不用括号
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// 用括号
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Runoob");
		greetService2.sayMessage("Google");
		
		final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
        Converter<Integer, String> s1 = new Converter<Integer, String> (){
			@Override
			public void convert(int param) {
				System.out.println(String.valueOf(param + num));
				
			}
		};
		s1.convert(2);
        s.convert(2);  // 输出结果为 3
        
        new Thread(() -> System.out.println("Hello world !")).start();
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello world !");
				
			}
		}).start();*/
        
        copmare();
	}
	private static void copmare() {
		String[] players = {"Rafael Nadal", "Novak Djokovic",   
			    "Stanislas Wawrinka", "David Ferrer",  
			    "Roger Federer", "Andy Murray",  
			    "Tomas Berdych", "Juan Martin Del Potro",  
			    "Richard Gasquet", "John Isner"}; 
		
		// 1.1 匿名内部类排序
		Arrays.sort(players,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2.compareTo(o1));
			}
			
		});
		for (int i=0;i<players.length;i++)
        {
            System.out.println(players[i]);
        }
		
		// 1.2 使用 lambda expression 排序 players  
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));  
		Arrays.sort(players, sortByName);  
		  
		// 1.3 也可以采用如下形式:  
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));  
		
	}
	
	public interface Converter<T1, T2> {
        void convert(int i);
    }
	public static void lambda1() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello Lambda！");

			}
		};
		r.run();
		Runnable rl = () -> System.out.println("lambda 表达式！");
		rl.run();
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
}
