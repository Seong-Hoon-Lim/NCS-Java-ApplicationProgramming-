package com.kudangtang.jv200.mod007;

public class Count1 {
	public static int counter = 0;
	public int serialNumber;
	
	public Count1() {
		counter++;
		serialNumber = counter;
	}
	
	public String toString() {
		return "Count : " + serialNumber + "/" + counter;
	}
	
	public static void main(String[] args) {
		Count1[] c = new Count1[10];
		for(int i = 0; i < c.length; i++) {
			c[i] = new Count1();
		}
		
		for(Count1 c1 : c) {
			System.out.println(c1);
		}
	}
}
