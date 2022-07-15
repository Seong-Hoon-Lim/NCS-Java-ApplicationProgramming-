package org.basicexamplesentence.array;

import java.util.*;

public class SimpleLottoProgram {

	public static void main(String[] args) {
		
//		■ 간단한 로또 번호 생성기 프로그램
//		
//		1등부터 5등까지 존재
//		45개의 숫자 중에 6개의 숫자 맞추기
		
//		조건1. 6개의 숫자 중 5개의 숫자와 보너스 번호를 맞히면 2등
//		조건2. 6개의 숫자 중 5개의 숫자를 맞히면 3등
//		조건3. 6개의 숫자 중 4개의 숫자를 맞히면 4등
//		조건4. 6개의 숫자 중 3개의 숫자를 맞히면 5등
		
//		프로그램 알고리즘
//		1. 6개의 랜덤 숫자와 보너스 점수를 로또 배열에 저장한다.
//		2. 사용자에게 1~45 까지의 6개의 숫자를 입력 받아 배열에 저장한다.
//		   사용자에게 보너스 번호를 입력 받는다.
//		3. 사용자가 입력한 값과 로또 배열에 있는 값을 비교하여 동일한 값의 개수를 count한다.
//		4. 몇개의 숫자를 맞췄는지 조건에 따라 등수를 출력한다.
		
		// 사용자게에 입력받기
		Scanner sc = new Scanner(System.in);
		// 랜덤의 숫자 값 가져오기
		Random random = new Random();
		// 6개의 로또번호 저장할 배열
		int lottoAr[] = new int[6];
		// 사용자에게 6개의 숫자를 입력 받아 저장할 배열
		int userAr[] = new int[6];
		int bonus,bonusUser; //보너스 번호
		int count = 0; // 동일한 숫자가 몇개인지 카운팅 할 변수
		
//		1. 6개의 랜덤 숫자와 보너스 점수를 로또 배열에 저장한다.
		for (int i=0; i<6; i++) {
			lottoAr[i] = random.nextInt(45)+1; // 1~45 랜덤 숫자 입력
		}
		// 보너스번호 bonus = random
		bonus = random.nextInt(45)+1;
		
//		System.out.println("Lotto:"+Arrays.toString(lottoAr)
//		+", bonus:"+bonus); 검증
		
//		2. 사용자에게 1~45 까지의 6개의 숫자를 입력 받아 배열에 저장한다.
//		   사용자에게 보너스 번호를 입력 받는다.
		System.out.print("숫자 6개를 입력하세요:");
		for (int i=0; i<6; i++) {
			userAr[i] = sc.nextInt();
		}
		System.out.print("보너스 번호를 입력하세요:");
		bonusUser = sc.nextInt();
		
//		System.out.println("User:"+Arrays.toString(userAr)
//		+", bonus:"+bonusUser); 검증
		
//		3. 사용자가 입력한 값과 로또 배열에 있는 값을 비교하여 동일한 값의 개수를 count한다.
		for (int j=0; j<6; j++) {
			for (int i=0; i<6; i++) {
				if (lottoAr[j] == userAr[i]) {
				count++;
				}
			}
		}
		
//		System.out.println("총 맞춘 갯수:"+count); 검증
		
//		4. 몇개의 숫자를 맞췄는지 조건에 따라 등수를 출력한다.
		if (count==6) {
			System.out.println("축하드립니다! 1등입니다!");
		}
		else if (count==5) {
			if (bonus==bonusUser) {
			System.out.println("축하드립니다! 2등입니다!");
		}
			else {
				System.out.println("축하드립니다! 3등입니다!");
			}
		}
		else if (count==4) {
			System.out.println("축하드립니다! 4등입니다!");
		}
		else if (count==5) {
			System.out.println("축하드립니다! 5등입니다!");
		}
		else {
			System.out.println("아쉽네요 낙첨입니다");
		}
		

	}

}
