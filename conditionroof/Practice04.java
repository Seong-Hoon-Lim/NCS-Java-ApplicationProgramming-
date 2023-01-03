package com.hooney.conditionroof;

import java.util.Scanner;

public class Practice04 {
	
//	반복문 연습
/**
 * 문제1.
 * 생일을 받아서 탄생석을 보여주는 프로그램을 작성합니다. 무한루프이며 생월이 0일시에는 루프를 종료합니다.
	또한 예외처리를 통해 잘못된 생월, 생일(ex. 13월)같은 잘못된 값이 입력되지 않게 방지합니다.
 */
	
	Scanner sc = new Scanner(System.in);
	int month = 0;	
	String stone;
	
	public void birthStone() {
	
	while ( true ) {
		//생년 월 예외처리
		while ( true ) {
			System.out.println("태어난 월을 입력 해주세요.(0은 종료): ");
			month = sc.nextInt();
			
			if ( month >= 0 && month <= 12 ) {
				//탄생석 switch문
				switch ( month ) {
				case 1: stone = "가넷";
				break;
				case 2: stone = "자수정";
				break;
				case 3: stone = "아쿠아마린";
				break;
				case 4: stone = "다이아몬드";
				break;
				case 5: stone = "에메랄드";
				break;
				case 6: stone = "진주";
				break;
				case 7: stone = "루비";
				break;
				case 8: stone = "페리도트";
				break;
				case 9: stone = "사파이어";
				break;
				case 10: stone = "오팔";
				break;
				case 11: stone = "토파즈";
				break;
				case 12: stone = "터키석";
				break;
				}
				break;
			} 
			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}
			} 
		System.out.println("당신의 탄생석은: " + stone + "입니다.");
		break;
		}	
	
	}
	
}
