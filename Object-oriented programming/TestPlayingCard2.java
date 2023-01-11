package com.kudangtang.jv200.mod007;

public class TestPlayingCard2 {
	public static void main(String[] args) {
		PlayingCard2 card2 = new PlayingCard2(Suit2.SPADES, 2);
		System.out.println("card2: " + card2.getSuit().getName()
				+ "-" + card2.getRank());
//		PlayingCard card2 = new PlayingCard(47, 2);		//컴파일 Error 발생
		
	}
}
