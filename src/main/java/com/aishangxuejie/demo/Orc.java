package com.aishangxuejie.demo;

class Villain {
	private int i;

	protected int read() {
		return i;
	}

	protected void set(int ii) {
		i = ii;
	}

	public Villain(int ii) {
		i = ii;
	}

	public int value(int m) {
		return m * i;
	}
}

public class Orc extends Villain {

	private int j;

	public Orc(int jj) {
		super(jj);
		setJ(jj);
	}

	public void change(int x) {
		set(x);
		read();
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
}
