package com.kudangtang.jv200.mod007;

public class Count2 {
	public static int counter = 0;
	public int serialNumber;
	
	public Count2() {
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
		Count2[] c = new Count2[10];
		for(int i = 0; i < c.length; i++) {
			c[i] = new Count2();
		}
		
		for(Count2 c1 : c) {
			System.out.println(c1);
		}
	}
}
