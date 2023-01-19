package com.kudangtang.jv200.mod003;

/**
 * 1. 모든 클래스는 생성자를 가진다.
 * 2. 만약 작성자가 생성자를 명시적으로 지정해 주지 않으면 디폴트 생성자가 만들어진다.
 * 	-. 디폴트 생성자는 아규먼트를 가지지 않는다.
 *  -. 디폴트 생성자의 구현부는 비어있다.
 *  
 * @author Sage R Lee
 *
 */
public class MyDate {
	private int day;
	private int month;
	private int year;
	
	//디폴트 생성자의 모습
	public MyDate() {
		
	}
	
	public MyDate(int day, int m, int y) {
		this.day = day;
		month = m;
		year = y;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDetails() {
		return year + "-" + month + "-" + day;
	}
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	
}
