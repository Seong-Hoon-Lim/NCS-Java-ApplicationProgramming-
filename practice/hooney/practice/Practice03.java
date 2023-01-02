package com.hooney.practice;

import java.util.Scanner;

public class Practice03 {
	
//	조건문 if문 연습
//	문제3. 초등학교에서 1학년부터 4학년까지 중간고사 시험을 보았다. 
//    	  4학년은 70점 이상이면 합격, 그 이외의 학년은 60점 이상이면 합격이다. 
//    	  이를 판단하는 프로그램을 작성해보자.
//    	  점수가 0미만 100초과이면 경고문구 출력!

	public void testResult() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("학년을 입력해주세요: ");
		int grade = sc.nextInt();
		System.out.print("점수를 입력해주세요: ");
		int score = sc.nextInt();
		System.out.println();
		System.out.println();
		String gradeClass;
		
		if ( score < 0 || score > 100 ) {
			System.out.println("점수를 올바르게 입력해주세요!");
		}
		else {
			if ( grade > 4 ) {
				System.out.println("학년을 올바르게 입력해주세요!");
			}
			else {
				switch(grade) {
				case 1 : gradeClass = "1학년";
					break;
				case 2 : gradeClass = "2학년";
					break;
				case 3 : gradeClass = "3학년";
					break;
				default : gradeClass = "4학년";
				}
				if ( gradeClass == "4학년" ) {
					if ( score >= 70 ) {
						System.out.println("합격이에요!");
					}
					else {
						System.out.println("다음엔 더 노력하세요~!");
					}				
				}
				else {
					if ( score >= 60 ) {
						System.out.println("합격이에요!");
					}
					else {
						System.out.println("다음엔 더 노력하세요~!");
					}
				}
			}
		}
	}
}
