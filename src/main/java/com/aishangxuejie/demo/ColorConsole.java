package com.aishangxuejie.demo;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

/**
 * @author CuiGM
 * @date 2018年6月21日 上午8:30:04
 * @param name
 * @param pathName
 */
public class ColorConsole {
	public static void main(String[] args) {
		int i = 1 % 7;
		System.out.print( ansi().eraseScreen().fg(RED).a(i).fg(YELLOW).a(" World").reset());
		System.out.print( ansi().eraseScreen().fg(RED).a(i).fg(GREEN).a(" World") );
		System.out.println("asddfasdfdasfd");
	}
}
