package com.kudangtang.jv200.mod007;

public class Count2 {
	//메모리 횟수
	public static int counter = 0;	//static 변수
	public int serialNumber;
	
	//생성자가 만들어질 때 마다 작업 실행
	//몇번째 만들어진 객체인지 판별
	public Count2() {
		counter++;
		serialNumber = counter;		//인스턴스 변수
	}
	
	//전체 카운트가 몇개인지 알아내는 메소드
	public static int getTotalCount() {
		
		return counter;
	}
	
	//전체 시리얼 넘버가 몇개인지 알아내는 메소드
	public int getSerialNumber() {
		
		return serialNumber;
	}

	public String toString() {
		return "Count: " + getSerialNumber() + "/" + counter;
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
