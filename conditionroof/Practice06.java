package com.hooney.conditionroof;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice06 {
	
//	반복문 연습
	//나이 계산기
	public void ageCalc() {
	Scanner scanner = new Scanner(System.in);	
	Date date = new Date();	//데이터 타입 Date
	
	SimpleDateFormat year = new SimpleDateFormat("yyyy.MM.dd(E) HH:mm:ss:S");
	SimpleDateFormat monthDate = new SimpleDateFormat("MMdd");	
	
	String md1 = (monthDate.format(date));	//데이터 타입 String 변환
	int md2 = Integer.parseInt(md1);	//데이터 타입 int 변환
	
	System.out.println(year.format(date));
	
	try {		
			System.out.print("당신이 태어난 년도는?(1900~2100 숫자만 입력해주세요): ");
			int birthYear = scanner.nextInt();
			
			if ( birthYear > 1900 && birthYear < 2100 ) {
				
				System.out.print("당신이 태어난 월일은?(0101 식으로 숫자만 입력해주세요): ");
				int birthMonthDate = scanner.nextInt();				
					
					if ( birthMonthDate < md2 ) {
						System.out.print("당신은 올해 " + (2023-birthYear) + "세 입니다.");
					}
					else {
						System.out.println("당신은 올해 " + (2023-birthYear-1) + "세 입니다.");
					}
				}
			else {
				System.out.println("년도를 다시 입력해주세요");
			}
	} catch ( InputMismatchException e ) 
		{
			System.out.println("숫자만 다시 입력해주세요.");
		
		}
	
	
	}

}
