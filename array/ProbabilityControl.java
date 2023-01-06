package com.kudangtang.jv200.mod005;

import java.util.Scanner;

public class ProbabilityControl {
	/**
	 * 배열을 활용한 확률 제어하는 프로그램
	 * 임의의 크기를 입력받아 int형 배열 1개를 생성하는 메소드 생성
	 * 생성된 배열의 요소 중 랜덤으로 받은 정수 요소가
	 * 있는지를 검증하는 메서드를 생성 하고 확률을 구현한다
	 */
	
	int[] arr;
	int arraySize;
	int randomNum;
	
	Scanner scanner = new Scanner(System.in);
	
	//임의의 크기를 입력받는 배열 생성
	public int[] addArray() {
		System.out.print("배열의 크기를 입력하세요: ");
		arraySize = scanner.nextInt();
		arr = new int[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1);
		}		
		return arr;
		
	}
	//랜덤으로 받은 정수가 배열 요소 안에 있는지 검증
	public void arrayVerification() {
		randomNum = (int)(Math.random() * (arraySize-1));
		System.out.println(randomNum);
		for (int i = 0; i < arr.length; i++) {
			if ( arr[i] == randomNum ) {
				if ( Math.random() <= 0.7 ) {
					System.out.println("70% 확률로 찾았습니다");
				}
				else if ( Math.random() <= 0.5 ) {
					System.out.println("50% 확률로 찾았습니다");
				}
				else if ( Math.random() <= 0.3 ) {
					System.out.println("30% 확률로 찾았습니다");
				}
				else if ( Math.random() <= 0.3 ) {
					System.out.println("30% 확률로 찾았습니다");
				}
				else if ( Math.random() <= 0.1 ) {
					System.out.println("10% 확률로 찾았습니다");
				}
				else if ( Math.random() <= 0.01 ) {
					System.out.println("1% 확률로 찾았습니다");
				}
			}
		}
		System.out.println(randomNum + "를 찾았습니다");
	}
	
}
