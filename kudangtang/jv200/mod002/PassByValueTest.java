package com.kudangtang.jv200.mod002;

public class PassByValueTest {
	public static void changeInt(int value) {
		value = 55;
	}
	
	public static void changeObjectRef(MyDate ref) {
		ref = new MyDate(1, 1, 2000);
	}
	
	public static void changeObjectAttr(MyDate ref) {
		ref.setDay(4);
	}
	
	public static void main(String[] args) {
		MyDate date;
		int val;
		// Assign the int
		val = 11;
		// Try to change it
		changeInt(val);
		// What is the current value?
		System.out.println("Int value is: " + val); //Int value is: 11
		
		date = new MyDate(22, 7, 1964);
		changeObjectRef(date);
		System.out.println("MyDate: " + date.getDetails());//MyDate: 1964-7-22
		
		changeObjectAttr(date);
		System.out.println("MyDate: " + date.getDetails());//MyDate: 1964-7-4

	}

}
