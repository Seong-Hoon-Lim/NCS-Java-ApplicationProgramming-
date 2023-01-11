package com.kudangtang.jv200.mod007;

public enum Suit2 {
	SPADES ("Spades"),
	HEARTS ("Hearts"),
	CLUBS ("Clubs"), 
	DIAMONDS ("Diamonds");
	
	private String name;
	
	private Suit2(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}


