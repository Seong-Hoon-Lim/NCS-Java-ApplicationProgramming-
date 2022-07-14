package org.basicexamplesentence.condition;

import java.util.Random;
import java.util.Scanner;

public class UpDown {

	public static void main(String[] args) {
		
		// 랜덤 수 만드는 객체 생성
		Random randomNumber = new Random();
		// 100 까지의 수를 랜덤으로 지정
		int Answer = randomNumber.nextInt(100);
		// 정해진 숫자를 출력
		System.out.println("정해진 숫자는: " + Answer + "입니다");
		
		int inputNum = 0; // 입력 숫자
		int chance = 5; // 찬스 갯수
		
		// 5번의 기회를 제공 하기 위한 	반복문
		while (chance > 0) {
			System.out.println("남은 기회는" + chance);
			System.out.println("1~100 의 숫자를 맞혀보세요");
			chance --;
			
			// 숫자를 입력
			Scanner scan = new Scanner(System.in);
			inputNum = scan.nextInt();
			
			if (inputNum > Answer) {
				System.out.println("Down 해주세요");
			}
			if (inputNum < Answer) {
				System.out.println("Up 해주세요");
			}
			if (inputNum == Answer)
			break;
			} 
		if (inputNum == Answer) {
			System.out.println("정답입니다.");
		}
		if (chance == 0) {
			System.out.println("안타깝네요 다음에 다시 도전하세요.");
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
