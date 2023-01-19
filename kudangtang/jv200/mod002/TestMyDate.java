package com.kudangtang.jv200.mod002;

public class TestMyDate {
	public static void main(String[] args) {
		MyDate m = new MyDate();
		m.setDay(2);
		m.setMonth(1);
		m.setYear(2023);
		
		String dayInfo = m.getDetails();
		System.out.println(dayInfo);
	}
}
