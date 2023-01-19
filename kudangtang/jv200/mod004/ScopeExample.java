package com.kudangtang.jv200.mod004;

public class ScopeExample {
	private int i = 1;
	
	public void firstMethod() {
		int i = 4;
		int j = 5;
		this.i = i + j;
		secondMethod(7);
	}
	
	public void secondMethod(int i) {
		this.i = i;
	}
	
	public static void main(String[] args) {
		ScopeExample ex = new ScopeExample();
		ex.firstMethod();
		System.out.println("ex객체 i = " + ex.i);
	}
}
