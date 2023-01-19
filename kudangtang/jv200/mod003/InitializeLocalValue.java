package com.kudangtang.jv200.mod003;

public class InitializeLocalValue {
	public void doComputation() {
		int x = (int)(Math.random() * 100);
		int y = 0;
		int z;
		if(x > 50) {
			y = 9;
		}
		z = y + x;
		System.out.println("z = " + z);
	}
	
	public static void main(String[] args) {
		InitializeLocalValue val = new InitializeLocalValue();
		val.doComputation();
	}
}
