package bookmarket.welcome;

import java.util.Scanner;

public class Welcome {
	/**
	 * 온라인 서점 프로젝트
	 * 메인 메뉴 만들기
	 * 메인 메뉴 선택하기
	 * 메뉴 조건에 따라 정보 표시 및 종료하기
	 * 메뉴별 기능(메소드) 만들기
	 * 도서 목록 표시하기
	 * 
	 * @author "SeongHoon"
	 */
	
	static final int NUM_BOOK = 3;	//도서의 개수에 대한 상수
	static final int NUM_ITEM = 7;	//도서정보의 개수에 대한 상수
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String[][] mbook = new String[NUM_BOOK][NUM_ITEM];	//도서 정보르 저장할 2차원 배열
		
		
		System.out.print("이름을 입력해주세요: ");
		String userName = input.next();
		
		System.out.print("연락처를 입력해주세요: ");
		int userMobile = input.nextInt();
		
//		System.out.println("Welcome to Shopping Mall");
//		System.out.println("Welcome to Book Market!");
		
		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to Book Market!";
		
		boolean quit = false;	//종료 여부 설정 변수
		
		//quit true면 반복 종료
		while (!quit) {
		System.out.println("********************************************");
		System.out.println("\t" + greeting);
		System.out.println("\t" + tagline);
		
		
		/*
		System.out.println("********************************************");
		System.out.println(" 1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t8. 종료");
		System.out.println("********************************************");
		*/
		
		menuIntroduction();	//메뉴 목록 출력
		
		System.out.print("메뉴 번호를 선택해주세요: ");
		int n = input.nextInt();
//		System.out.println(n + "번을 선택했습니다");
		
		if (n<1 || n>8) {
			System.out.println("1부터 8까지의 숫자를 입력하세요");
		}
		else {
			switch (n) {
			case 1:
//				System.out.println("1. 현재 고객 정보: ");
//				System.out.println("이름: " + userName + "/ 연락처 " + userMobile);
				menuGuestInfo(userName, userMobile);	//고객 정보 출력
				break;
			case 2:
//				System.out.println("2. 장바구니 상품 목록 보기: ");
				menuCartItemList();
				break;
			case 3:
//				System.out.println("3. 장바구니 비우기: ");
				menuCartClear();
				break;
			case 4:
//				System.out.println("4. 장바구니에 항목 추가하기: ");
				menuCartAddItem();
				break;
			case 5:
//				System.out.println("5. 장바구니의 항목 수량 줄이기: ");
				menuCartRemoveItemCount();
				break;
			case 6:
//				System.out.println("6. 장바구니의 항목 삭제하기: ");
				menuCartRemoveItem();
				break;
			case 7:
//				System.out.println("7. 영수증 표시하기: ");
				menuCartBill();
				break;
			case 8:
//				System.out.println("8. 종료 ");
				menuExit();
				quit = true;	//반복문 종료 조건
				break;
				}
			}
		}	//while 문 끝
		
	}
	
	//메뉴 목록 출력 기능
	public static void menuIntroduction() {
		System.out.println("********************************************");
		System.out.println(" 1. 고객 정보 확인하기 \t4. 바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기 \t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t8. 종료");
		System.out.println("********************************************");
	}
	
	//고객 정보 출력 기능
	public static void menuGuestInfo(String name, int mobile) {
		System.out.println("현재 고객 정보: ");
		System.out.println("이름: " + name + "/ 연락처 " + mobile);
	}
	
	public static void menuCartItemList() {
		System.out.println("2. 장바구니 상품 목록 보기: ");
	}
	
	public static void menuCartClear() {
		System.out.println("3. 장바구니 비우기: ");
	}
	
	//장바구니에 도서를 추가하는 메서드
	public static void menuCartAddItem(String[][] book) {
//		System.out.println("4. 장바구니에 항목 추가하기: ");
		
//		BookList(book);	//도서 정보를 저장하는 메소드 호출
//		
//		for (int i = 0; i < NUM_BOOK; i++) {
//			for (int j = 0; j < NUM_ITEM; j++) {
//				System.out.print(book[i][j] + " : ");	//도서정보 출력
//			System.out.println(" ");
//			}
//		}
		
		boolean quit = false;
		
		//장바구니에 항목을 추가하지 않을 때까지 반복
		while (!quit) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요: ");
			
			//도서 ID입력 받기
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			boolean flag = false;
			int numId = -1;
			
			/**
			 * 입력된 도서의 ID와 저장된 도서의 ID가 일치하는지 확인
			 * 일치하면 도서 정보의 numId(index 번호)와 flag(일치 여부) 변수에
			 * 값을 변경하여 저장하고 반복문 종료
			 */
			for (int i = 0; i < NUM_BOOK; i++) {
				if (str.equals(book[i][0])) {
					numId = i;
					flag = true;
					break;
				}				
			}
			
			/**
			 * 변수 flag가 참이면 (입력된 도서의 ID와 저장되어 있는 도서 정보의 ID가 일치하면)
			 * 반복문을 종료하고, 거짓이면 "다시 입력해주세요" 출력
			 */
			if (flag) {
				System.out.println("장바구니에 추가하겠습니까? Y | N");
				str = input.nextLine();		//장바구니에 도서 추가 여부를 위한 입력값(Y 또는 N)을 받음

				//입력값(Y 또는 N)을 대문자로 변경하여 Y이면 도서가 장바구니에 추가되었습니다

				if (str.toUpperCase().equals("Y")) {
					System.out.println(book[numId][0] + " 도서가 장바구니에 추가되었습니다");					
				}				
				quit = true;				
			}
			else
				System.out.println("다시 입력해주세요");			
		}	//반복문 종료
	}
	
	public static void menuCartRemoveItemCount() {
		System.out.println("5. 장바구니의 항목 수량 줄이기: ");
	}
	
	public static void menuCartRemoveItem() {
		System.out.println("6. 장바구니의 항목 삭제하기: ");
	}
	
	public static void menuCartBill() {
		System.out.println("7. 영수증 표시하기: ");
	}
	
	public static void menuExit() {
		System.out.println("8. 종료");
	}
	
	//도서 정보를 저장하는 메소드
	public static void BookList(String[][] book) {
		book[0][0] = "ISBN1234";
		book[0][1] = "쉽게 배우는 JSP 웹 프로그래밍";
		book[0][2] = "27000";
		book[0][3] = "송미영";
		book[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
		book[0][5] = "IT전문서";
		book[0][6] = "2018/10/08";		
		
		book[1][0] = "ISBN1235";
		book[1][1] = "안드로이드 프로그래밍";
		book[1][2] = "33000";
		book[1][3] = "우재남";
		book[1][4] = "실습 단계별 명쾌한 멘토링";
		book[1][5] = "IT전문서";
		book[1][6] = "2022/01/22";
		
		book[2][0] = "ISBN1236";		
		book[2][1] = "스크래치";		
		book[2][2] = "22000";		
		book[2][3] = "고광일";		
		book[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";		
		book[2][5] = "컴퓨터입문";		
		book[2][6] = "2019/06/10";		
		
	}	
	
}
