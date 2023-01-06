package com.kudangtang.jv200.mod005;

import java.util.Scanner;

public class ArrayComparison {
	/**
	 * 복사된 배열의 요소 구성을 비교하는 프로그램
	 * 1개의 int형 배열 arrayA 를 생성한다
	 * int형 배열을 카피해서 arrayB 를 생성한다
	 * 두 배열의 첫번째 인덱스와 마지막 인덱스
	 * 값의 조건연산을 통해 포함여부 검사
	 */
	
	//배열 생성
	Scanner scanner = new Scanner(System.in);
	int arraysize1;
	int arraysize2;
	int indexCheckNum;
	int[] arrayA;
	int[] arrayB;
	//배열 arrayA에 값 추가
	public int[] arrayPutValue() {
		System.out.print("arrayA 배열의 크기를 입력해주세요: ");
		arraysize1 = scanner.nextInt();
		arrayA = new int[arraysize1];
		for (int i = 0; i < arrayA.length; i++) {
			arrayA[i] = (i + 1);
		}
		return arrayA;
	}
	
	//배열 arrayB 에 값 복사
	//검증을 위한 index 값을 생성
	public int[] arrayCopy() {
		System.out.print("arrayB 배열의 크기를 입력해주세요: ");
		arraysize2 = scanner.nextInt();
		System.out.println();
		System.out.println();
		System.out.print("index 검증 값을 입력해주세요: ");
		indexCheckNum = scanner.nextInt();
		arrayB = new int[arraysize2];
		System.arraycopy(arrayA, 0, arrayB, indexCheckNum, arraysize2-indexCheckNum);
		return arrayB;
	}
	
	//두 배열의 구성 요소가 같은지 비교해서 출력하는 메서드 생성
	//두 배열의 요소 null 값 검사
	//두 배열의 구성 요소와 길이 같은지 검사
	public void elementComparison() {
		if ( arrayA[arraysize1-indexCheckNum-1] != arrayB[arraysize2-indexCheckNum-1] ) {
			System.out.println("arrayA와 arrayB는 요소가 같지 않습니다.");
		}
		//null에 대한 에러 방지
		else if ( arrayA == null || arrayB == null ) {
			System.out.println("arrayA와 arrayB의 값이 없습니다.");
		}
		//두 배열의 길이 비교
		else if ( arrayA.length != arrayB.length ) {
			System.out.println("arrayA와 arrayB는 크기가 같지 않습니다.");
		}
		else {
			System.out.println("arrayA와 arrayB는 요소도 크기도 같습니다.");
		}
		
	} 
}