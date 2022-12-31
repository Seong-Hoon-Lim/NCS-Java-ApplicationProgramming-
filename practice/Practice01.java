package demo.java.practice;

import java.util.Scanner;

public class Practice01 {
	
//	조건문 if문 연습
//	문제1. 정수 한 개를 입력받아서, 그 수가 50 이상의 수인지 50미만의 수인지 판단

	public Practice01() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: \n");
		
		try {
			int num = Integer.parseInt(sc.next());
			if ( num >= 50 ) {
				System.out.println(num + "은 50 이상입니다.");
			}
			else if ( num <= 50 ) {
				System.out.println(num + "은 50 이하입니다.");
			}
		
			} 
		catch(NumberFormatException e) {
			System.out.println("정수를 입력 해주세요!");
		}
			

	}
	
}
