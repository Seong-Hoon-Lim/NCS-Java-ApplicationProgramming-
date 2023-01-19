package com.kudangtang.jv200.mod007;

public class FlyerTest {
	public static void main(String[] args) {
		Flyer f = new Airplane();
		f.takeOff();
		f.fly();
		f.land();
		
		f = new Bird();
		f.takeOff();
		f.fly();
		f.land();
		
		f = new IronMan();
		f.takeOff();
		f.fly();
		f.land();
	}
}
