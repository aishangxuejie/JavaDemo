package com.aishangxuejie.java8.Strategy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

public class App {

	private List<Apple> apples;

	@Before
	public void before() {
		apples = Arrays.asList(new Apple(50, Color.BROWN), new Apple(100, Color.BROWN), new Apple(150, Color.RED),
				new Apple(110, Color.GREEN), new Apple(60, Color.GREEN));
	}

	/**
	 * 常规测试
	 */
	@Test
	public void strategyTest() {
		Filter colorFilter = new Filter(new ColorStrategy());
		colorFilter.excute(apples);
		System.out.println("==============");
		Filter weightFilter = new Filter(new WeightStrategy());
		weightFilter.excute(apples);
	}

	/**
	 * 匿名内部类测试
	 */
	@Test
	public void strategyTestInnerClazzTest() {
		Filter filter = new Filter(new Strategy() {
			@Override
			public boolean test(Apple apple) {
				return apple.getColor().equals(Color.RED);
			}
		});
		filter.excute(apples);
	}

	/**
	 * Java测试（lambd）
	 */
	@Test
	public void strategyTestJava8Test() {
		Filter filter = new Filter((apple -> {
			return apple.getColor().equals(Color.GREEN);
		}));
		
		filter.excute(apples);
	}
	//使用 java 8 语法 究极进化！=======================================
    @Test
    public void java8Test() {
    	
        excute(apples, apple -> {
            return apple.getColor().equals(Color.GREEN);
        });
    }

    public static void excute(List<Apple> apples, Predicate<Apple> predicate) {
    	
    	/*for (Apple apple : apples) {
    		if (predicate.test(apple)) {
    			System.out.println(apple);
    		}
    	}*/
    	
    	// =====>>>>> 究极进化 =======>>>>>>
    	apples.stream().filter(a -> predicate.test(a)).forEach(System.out::print);
    	
    }
}
