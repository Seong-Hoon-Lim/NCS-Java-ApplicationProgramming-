package org.basicexamplesentence.array;

import java.awt.BorderLayout;
import java.io.StreamCorruptedException;
import java.util.*;

public class SimpleCafeProgram {

	public static void main(String[] args) {
		
//		■ 카페 프로그램
		
//		<프로그램 알고리즘>
//		
//		1. 카페 프로그램에는 어떤 기능이 있는가?	
//		카페 프로그램 기능
//		 1) 주문하기
//		  ① 주문 가능한 메뉴를 출력한다.
//		  ② 주문 받을 메뉴를 입력 받는다.
//		  ③ 주문한 메뉴의 가격을 총 금액에 누적한다.
//		  ④ 주문한 메뉴를 전체 메뉴리스트에 추가한다.
//		  ⑤ 주문한 개수를 한 개 증가시킨다.
//		 2) 취소하기
//		  ① 주문한 메뉴리스트를 출력한다.
//		  ② 그 중에서 취소한 메뉴를 입력 받는다.
//		  ③ 입력 받은 메뉴를 주문리스트에서 제거한다.
//		  ④ 입력 받은 메뉴의 금액을 총 금액에서 차감한다.
//		  ⑤ 주문한 개수를 한 개 감소시킨다.  
//		 3) 결제하기
//		  ① 결제해야 할 총 금액을 출력한다.
//		  ② 사용자에게 지불할 금액을 입력 받는다.
//		  ③ 지불한 금액과 총 금액을 비교해서, 만약, 지불한 금액 < 총 금액이면
//		    "잔돈이 부족합니다." 출력 후 결제 취소 아니라면,
//		    잔돈과 함께 계산완료를 출력한다.
//		  ④ 총 금액은 0원으로 주문리스트는 비워준다.
//		  ⑤ 전체 개수를 0개로 초기화한다.
//		  4) 끝내기
//		  
//		2. 알고리즘 기반으로 코드 구현하기
//		 1) 활용개념
//		  ① 반복문 사용
//		  ② 문자열 배열
//		 2) 필요한 변수
//		  ① 전체 개수 저장할 변수
//		  ② 주문한 메뉴를 저장할 문자열 배열
//		  ③ 총 금액 저장할 변수
//		
//		

		Scanner sc = new Scanner(System.in);
		int count = 0;
		// 주문은 총 5개 까지 가능
		String orderList[] = new String[5];
		int total = 0;
		// 주문 반복
		while (true) {
			System.out.println("☆★☆★ Cafe 입니다 ☆★☆★");
			System.out.println("1. 주문하기");
			System.out.println("2. 취소하기");
			System.out.println("3. 결제하기");
			System.out.println("4. 끝내기");
			System.out.print("입력: ");
			int num = sc.nextInt();
			if (num==1) {
				String menuName = ""; //오류 방지를 위한 초기화
				int menuPrice=0; //오류 방지를 위한 초기화
				System.out.println("1. 아메리카노\t3800원");
				System.out.println("2. 에스프레소\t2400원");
				System.out.println("3. 카페라떼\t4200원");
				System.out.println("4. 밀크티\t\t5100원");
				System.out.print("주문할 메뉴번호:");
				int menuNum = sc.nextInt();
				if (menuNum==1) {
					menuName = "아메리카노";
					menuPrice = 3800;
				}
				else if (menuNum==2) {
					menuName = "에스프레소";
					menuPrice = 2400;
				}
				else if (menuNum==3) {
					menuName = "카페라떼";
					menuPrice = 4200;
				}
				else if (menuNum==4) {
					menuName = "밀크티";
					menuPrice = 5100;
				}
				else {
					System.out.println("잘못입력하셨습니다.");
					continue;
				}
				total+=menuPrice; // 주문 메뉴의 가격을 총 금액에 누적
				orderList[count] = menuName;
				count++;
				
				System.out.println("주문한 메뉴는"+menuName+"입니다.");
				System.out.println("가격은"+menuPrice+"입니다.");
			}
			else if (num==2) {
				System.out.println("---주문한 메뉴 리스트---");
				for (int i=0; i<count; i++) {
					System.out.println(i+1+"."+orderList[i]);
				}
				System.out.println("취소할 메뉴번호:");
				int cancelNum = sc.nextInt();
				if (1<=cancelNum && cancelNum<=count) {
					String delMenu = orderList[cancelNum-1];
					System.out.println(delMenu+"메뉴 삭제!");
					for (int i=cancelNum-1; i<count; i++) {
						orderList[i] = orderList[i+1];						
					}
					if (delMenu.equals("아메리카노")) {
						total-=3800;
					}
					else if (delMenu.equals("에스프레소")) {
						total-=2400;
					}
					else if (delMenu.equals("에스프레소")) {
						total-=4200;
					}
					else if (delMenu.equals("에스프레소")) {
						total-=5100;
					}
					count--;
				}
				
			}
			else if (num==3) {
				System.out.println("결제할 금액:"+total+"원");
				System.out.print("지불할 금액:");
				int money = sc.nextInt();
				if (money<total) {
					System.out.println("잔돈이 부족합니다.");
					continue;
				}
				else {
					System.out.println("잔돈은"+(money-total)+"원입니다.");
					total = 0;
					for (int i=0; i<5; i++) {
						orderList[i]="";
					}
					count = 0;
				}
				
			}
			else if (num==4) {
				System.out.println("다시 입력해주세요. 프로그램을 종료합니다");
				break;
			}
			else {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
