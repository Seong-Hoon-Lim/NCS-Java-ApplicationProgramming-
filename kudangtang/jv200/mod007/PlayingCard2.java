package com.kudangtang.jv200.mod007;
/**
 * 
 * @author Sage R Lee
 *
 */
public class PlayingCard2 {
	private Suit2 suit;
	private int rank;
	
	public PlayingCard2(Suit2 suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public Suit2 getSuit() {
		return this.suit;
	}
	
	public int getRank() {
		return this.rank;
	}
}
