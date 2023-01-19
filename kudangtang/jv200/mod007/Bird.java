package com.kudangtang.jv200.mod007;

public class Bird implements Flyer{

	@Override
	public void takeOff() {
		System.out.println("새 : 이륙하기");
	}

	@Override
	public void land() {
		System.out.println("새 : 착륙하기");
		
	}

	@Override
	public void fly() {
		System.out.println("새 : 비행하기");
	}

}
