package com.kudangtang.jv200.mod007;

public class IronMan implements Flyer{

	@Override
	public void takeOff() {
		System.out.println("아이언 맨 : 이륙하기");
	}

	@Override
	public void land() {
		System.out.println("아이언 맨 : 착륙하기");
		
	}

	@Override
	public void fly() {
		System.out.println("아이언 맨 : 비행하기");
	}

}
