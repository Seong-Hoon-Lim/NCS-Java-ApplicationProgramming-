package com.kudangtang.jv200.mod007;

public class PlayingCard {
	private Suit suit;
	private int rank;
	
	public PlayingCard(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String getSuitName() {
		String name="";
		switch (suit) {
			case SPADES:
				name = "Spades";
				break;
			case HEARTS:
				name = "Hearts";		
				break;
			case CLUBS:
				name = "Clubs";
				break;
			case DIAMONDS:
				name = "Diamonds";
				break;
	
			default:
				break;
		}
		return name;
	}
}
