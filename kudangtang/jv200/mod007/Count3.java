package com.kudangtang.jv200.mod007;

public class Count3 {
	public static int counter = 0;
	public int serialNumber;

	static {
		System.out.println("static initializer called");
	}
	public Count3() {
		counter++;
		serialNumber = counter;
	}
	
	public static int getTotalCount() {
		return counter;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	
	public String toString() {
		return "Count : " + getSerialNumber() + "/" + getTotalCount();
	}
	
	public static void main(String[] args) {
		Count3[] c = new Count3[10];
		for(int i = 0; i < c.length; i++) {
			c[i] = new Count3();
		}
		
		for(Count3 c1 : c) {
			System.out.println(c1);
		}
	}
}
