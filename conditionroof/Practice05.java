package com.hooney.conditionroof;

import java.util.Scanner;

public class Practice05 {
	
//	반복문 연습
/**
 * 문제2.
 * 가위바위보 게임 만들어보기 (switch문 응용)
 * 가위 바위 보의 선택 값을 입력받고, 컴퓨터는 랜덤으로 가위 바위 보를 내도록 해야한다.
 * (Hint : 랜덤 메소드 사용)
 */
	
	//paper 보(1), rock 바위(2), scissor 가위(3) 변수 지정
	int paper = 1, rock = 2, scissor = 3;
	//컴퓨터의 생성 값
	int com = (int)(Math.random() *3) + 1;
	//가위,바위,보 게임 함수
	public void paperRockScissors() {
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(3) 바위(2) 보(1) 중에 하나를 입력하세요 : ");
		//유저의 입력 값
		int user = sc.nextInt();
		
		while ( true ) {
		if ( user == 1 || user == 2 || user ==3 ) {
			if ( user == com ) {
				System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 무승부입니다.");
			}
			else {
				if ( user == 1 ) {
					if ( com == 2 ) {
						System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 당신이 이겼습니다.");
					}
					else if ( com == 3 ) {
						System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 컴퓨터가 이겼습니다.");
					}
				}
				else if ( user == 2 ) {
					if ( com == 1 ) {
						System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 컴퓨터가 이겼습니다.");
					}
					else if ( com == 3 ) {
						System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 당신이 이겼습니다.");
					}
				}
				else if ( user == 3 ) {
					if ( com == 1 ) {
						System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 당신이 이겼습니다.");
					}
					else if ( com == 2 ) {
						System.out.println("당신은: " + user + "," + "컴퓨터는: " + com + "으로 컴퓨터가 이겼습니다.");
					}
				}
			}
		}
		else {
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요");
			} break;
		
		
		}
	}

}
