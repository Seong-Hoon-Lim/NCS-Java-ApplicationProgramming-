package demo.java.practice;

import java.util.Scanner;

public class Practice02 {
	
//	조건문 if문 연습
//	문제2. 정수 한 개를 입력받아서, 그 수가 3의 배수인지 판단해보자.

	public Practice02() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력해주세요: \n");
		try {
			int num = Integer.parseInt(sc.next());
			if ( num % 3 == 0 ) {
				System.out.println(num + "은 3의 배수입니다.");
			}
			else if ( num % 3 != 0 ) {
				System.out.println(num + "은 3의 배수가 아닙니다.");
			}
		
			} 
		catch(NumberFormatException e) {
			System.out.println("정수를 입력 해주세요!");
		}
	}
}
