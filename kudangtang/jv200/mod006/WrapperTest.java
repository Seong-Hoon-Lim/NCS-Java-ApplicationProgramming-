package com.kudangtang.jv200.mod006;

public class WrapperTest {
	public static void main(String[] args) {
		int i = 100;
		Integer integer = new Integer(i);
		System.out.println(i);
		System.out.println(integer.toString());
		System.out.println(integer.intValue());
		
		//auto (un)boxing
		int num = new Integer(200);	
		Integer integer2 = num;
	}
}
