package com.kudangtang.jv200.mod007;

public class TestPlayingCard2 {
	public static void main(String[] args) {
		PlayingCard2 card = new PlayingCard2(Suit2.SPADES, 2);
		System.out.println("card : " + card.getSuit().getName() 
							+ "-"+ card.getRank());
		
		//PlayingCard card2 = new PlayingCard(47, 2);
		
	}
}
