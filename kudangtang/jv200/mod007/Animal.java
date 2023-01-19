package com.kudangtang.jv200.mod007;

public abstract class Animal {
	protected String type;			//포유류, 조류, 어류
	protected boolean eatable;
	
	public Animal(String type) {
		this(type, false);
	}
	
	public Animal(String type, boolean eatable) {
		this.type = type;
		this.eatable = eatable;
	}
	
	public abstract void makeSound();	//추상 메소드
	
	public static void main(String[] args) {
		//추상 클래스는 객체 생성 불가
		//Animal a = new Animal("포유류", false);
		
		Animal d = new Dog("포유류", true);
		d.makeSound();
	}
}
