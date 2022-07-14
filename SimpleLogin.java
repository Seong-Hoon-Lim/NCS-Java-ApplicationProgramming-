package org.basicexamplesentence.condition;

import java.util.Scanner;

public class SimpleLogin {

	public static void main(String[] args) {
		
		String id, password; //문자열의 id 와 pw 변수 지정
		Scanner input = new Scanner(System.in);
		System.out.println("ID를 입력해주세요.");
		id = input.nextLine(); // id 띄어쓰기 까지 입력받기
		
		if (id.equals("ID")) {
			System.out.println("아이디 일치!");
			System.out.println("패스워드를 입력해주세요.");
			password = input.nextLine(); // pw 띄어쓰기 까지 입력받기
			
			if (password.equals("PW")) {
				System.out.println("패스워드 일치!");
				System.out.println("로그인 성공하였습니다.");
			}
			else {
				System.out.println("패스워드 불일치!");
				System.out.println("아이디와 패스워드를 다시 입력해주세요");
			}
		}
		else
		{
			System.out.println("아이디 불일치!");
			System.out.println("아이디와 패스워드를 다시 입력해주세요");
		}
		

	}

}
