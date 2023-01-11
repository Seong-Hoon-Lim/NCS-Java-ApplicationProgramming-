package com.kudangtang.jv200.mod007;

public class Count1 {
	//메모리 횟수
	public static int counter = 0;	//static 변수
	public int serialNumber;
	
	//생성자가 만들어질 때 마다 작업 실행
	//몇번째 만들어진 객체인지 판별
	public Count1() {
		counter++;
		serialNumber = counter;		//인스턴스 변수
	}
	
	public String toString() {
		return "Count: " + serialNumber + "/" + counter;
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
