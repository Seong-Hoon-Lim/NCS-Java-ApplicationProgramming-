package com.kudangtang.jv200.mod007;

public class Airplane implements Flyer {

	@Override
	public void takeOff() {
		System.out.println("비행기 : 이륙하기");
	}

	@Override
	public void land() {
		System.out.println("비행기 : 착륙하기");
	}

	@Override
	public void fly() {
		System.out.println("비행기 : 비행하기");
	}

}
