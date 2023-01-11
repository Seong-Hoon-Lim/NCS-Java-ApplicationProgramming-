package com.kudangtang.jv200.mod007;

public class TestPlayingCard {
	public static void main(String[] args) {
		PlayingCard card = new PlayingCard(Suit.SPADES, 2);
		System.out.println("card: " + card.getSuitName()
				+ "-" + card.getRank());
//		PlayingCard card2 = new PlayingCard(47, 2);		//컴파일 Error 발생
		
	}
}
