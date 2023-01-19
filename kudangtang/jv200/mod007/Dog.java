package com.kudangtang.jv200.mod007;

public class Dog extends Animal{
	public Dog(String type) {
		this(type, false);
	}
	
	public Dog(String type, boolean eatable) {
		super(type, eatable);
	}

	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}
}
