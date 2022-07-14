package org.basicexamplesentence.Operator;

import java.util.Scanner;

// 신호등 프로그램(삼항연산자 실습)
public class TrafficLight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("★☆★☆★☆신호등 프로그램★☆★☆★☆");
		System.out.println("신호를 입력해보세요~");
		System.out.println("빨간불:1, 초록불:2, 노란불:3");
		System.out.println("신호를 입력하세요 >> ");
		int sign = sc.nextInt(); //신호 입력 메서드
		String result; //출력 결과값을 문자열 형태로 변수 지정
		result=(sign==1)?"정지하세요":(sign==2)?"출발하세요"
				:(sign==3)?"서행하세요":"잘못입력했습니다. 프로그램을 종료합니다."; 
		//삼항연산자 활용
		System.out.println(result);
		sc.close();

	}

}
