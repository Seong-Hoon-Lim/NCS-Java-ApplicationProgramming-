package com.hooney.array;

public class ArrayComparison {
	/**
	 * 2개의 배열을 생성한다
	 * 각 배열의 요소는 똑같은 자료형을 갖고 있다
	 * 2개의 배열을 매개변수로 받는다
	 * 두 배열의 각 요소들이 서로 포함 관계인지 검사하는 알고리즘 구현
	 */
	
	//매개변수로 받기 위해 메소드 밖에 배열 생성
	private int A;
	private int B;
	private int[] arrayA;
	private int[] arrayB;
	
	//2개의 배열을 (int형 배열 2개 arrayA, arrayB) 매개변수로 받기위해 생성자 선언
	public ArrayComparison(int A, int B) {
		this.A = A;
		this.B = B;
	}
	
	//각 배열을 생성하고 값담기
	public void putValue() {
		for (int i = 0; i < arrayA.length; i++) {
			for (int j = 0; j < arrayB.length; j++) {
				System.out.println(arrayB[j]);
			}
			System.out.println(arrayB[i]);
		}
	}		
	
	//두 배열의 구성 요소가 같은지 비교해서 출력하는 메서드 생성
	//두 배열의 요소 null 값 검사
	//두 배열의 구성 요소와 길이 같은지 검사
	public boolean elementComparison() {
		if ( arrayA == arrayB ) {
			return true;
		}
		//null에 대한 에러 방지
		else if ( arrayA == null || arrayB == null ) {
			return false;
		}
		//두 배열의 길이 비교
		else if ( arrayA.length != arrayB.length ) {
			return false;
		}
		
		return true;
	} 
}
