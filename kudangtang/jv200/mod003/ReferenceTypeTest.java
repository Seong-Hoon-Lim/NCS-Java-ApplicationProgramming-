package com.kudangtang.jv200.mod003;

public class ReferenceTypeTest {
	public static void main(String[] args) {
		MyDate date = new MyDate(22, 7, 1964);
		MyDate date2 = date;
		
		System.out.println(date == date2);
		
		date2 = new MyDate(22, 7, 1964);
		System.out.println(date == date2);
		
		date = date2;
		System.out.println(date == date2);
	}
}
