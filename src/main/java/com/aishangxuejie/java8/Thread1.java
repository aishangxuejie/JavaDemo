package com.aishangxuejie.java8;

public class Thread1 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}  
					System.out.println("t11111");
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t2222");
				}
			}
		});
		t1.start();
		t2.start();
	}
	
	
}
