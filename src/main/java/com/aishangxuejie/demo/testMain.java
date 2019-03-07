package com.aishangxuejie.demo;

class testMain {
	public static void main(String[] args) throws InterruptedException {
		// true or false ?
		Long l = 0L;
		System.out.print("1  ");
		String s = l.toString();
		System.out.println(s == "0");//false
		/**
		 * 
		Long.class 源码中，可以看到 return new String(buf,true);
		
		public static String toString(long i) {
	        if (i == Long.MIN_VALUE)
	            return "-9223372036854775808";
	        int size = (i < 0) ? stringSize(-i) + 1 : stringSize(i);
	        char[] buf = new char[size];
	        getChars(i, size, buf);
	        return new String(buf, true);
	    }
		 * 
		 */
		
		System.out.print("2  ");
		String a = "2";
		System.out.println(a == "2");//true
		
		System.out.print("3  ");
		String b = new String("3");
		System.out.println(b == "3");//false
		
		System.out.print("4  ");
		String c = new String("4");
		System.out.println(c.intern() == "4");//true
		
		System.out.print("5  ");
		String d = "abc";
		String e = "abc";
		System.out.println(d==e);//true
		
		System.out.print("6  ");
		String f = new String("xyz");
		String g = new String("xyz");
		System.out.println(f==g);//false
		
		String h = "1";
		String i = "2";
		String j = "3";
		System.out.println(h==String.valueOf(Integer.valueOf(j)-Integer.valueOf(i)));//false
		String k = String.valueOf(Integer.valueOf(j)-Integer.valueOf(i)).intern();
		System.out.println(h == k);//true

				
	}
}