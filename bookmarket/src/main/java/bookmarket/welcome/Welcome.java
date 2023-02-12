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
	 * 장바구니에 항목 추가하기
	 * 사용자,관리자 정보 관리 및 관리자 로그인 기능 만들기
	 * 장바구니 항목 삭제 및 비우기
	 * 
	 * @author "SeongHoon"
	 */
	
	static final int NUM_BOOK = 3;	//도서의 개수에 대한 상수
	static final int NUM_ITEM = 7;	//도서정보의 개수에 대한 상수
	
	static Cart mCart = new Cart();
	static User mUser;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Book[] mBookList = new Book[NUM_BOOK];
		
		
		System.out.print("이름을 입력해주세요: ");
		String userName = input.next();
		
		System.out.print("연락처를 입력해주세요: ");
		int userMobile = input.nextInt();
		
		mUser = new User(userName, userMobile);
		
		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to Book Market!";
		
		boolean quit = false;	//종료 여부 설정 변수
		
		//quit true면 반복 종료
		while (!quit) {
		System.out.println("********************************************");
		System.out.println("\t" + greeting);
		System.out.println("\t" + tagline);
		
		menuIntroduction();	//메뉴 목록 출력
		
		System.out.print("메뉴 번호를 선택해주세요: ");
		
		int n = input.nextInt();

		if (n < 1 || n > 9) {
			System.out.println("1부터 9까지의 숫자를 입력하세요");
		}
		else {
			switch (n) {
			case 1:
//				System.out.println("1. 현재 고객 정보: ");
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
				menuCartAddItem(mBookList);
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
			case 9:
				menuAdminLogin();
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
		System.out.println(" 9. 관리자 로그인");
		System.out.println("********************************************");
	}
	
	//고객 정보 출력 기능
	public static void menuGuestInfo(String name, int mobile) {
		System.out.println("현재 고객 정보: ");
		System.out.println("이름: " + mUser.getName() + "  연락처: " + mUser.getPhone());
		
	}
	
	//장바구니의 상품 목록을 출력하는 메소드
	public static void menuCartItemList() {
		if (mCart.mCartCount >= 0) {
			mCart.printCart();
		}
	}
	
	//장바구니에 항목을 모두 삭제하는 메소드
	public static void menuCartClear() {
		if (mCart.mCartCount == 0) 
			System.out.println("장바구니에 항목이 없습니다");
		
		else {
			System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			if (str.toUpperCase().equals("Y")) {
				System.out.println("장바구니의 모든 항목을 삭제했습니다.");
				mCart.deleteBook();
			}
		}
	}
	
	//장바구니에 도서를 추가하는 메소드
	public static void menuCartAddItem(Book[] bookList) {		
		System.out.println();
		BookList(bookList);	//도서 정보를 저장하는 메소드 호출
		
		mCart.printBookList(bookList);
		
		boolean quit = false;
		
		//장바구니에 항목을 추가하지 않을 때까지 반복
		while (!quit) {
			System.out.print("\n장바구니에 추가할 도서의 ID를 입력하세요: ");
			
			//도서 ID입력 받기
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			boolean flag = false;	//도서 정보의 일치여부
			int numId = -1;		//도서 정보의 Index 번호
			
			/**
			 * 입력된 도서의 ID와 저장된 도서의 ID가 일치하는지 확인
			 * 일치하면 도서 정보의 numId 변수와 flag 변수에
			 * 값을 변경하여 저장하고 반복문 종료
			 */
			for (int i = 0; i < NUM_BOOK; i++) {
				if (str.equals(bookList[i].getBookId())) {
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

				if (str.toUpperCase().equals("Y"))
					System.out.println(bookList[numId].getBookId() + " 도서가 장바구니에 추가되었습니다");	
					//장바구니에 넣기
					if (!isCartInBook(bookList[numId].getBookId())) {
						mCart.insertBook(bookList[numId]);
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
		if (mCart.mCartCount == 0) {
			System.out.println("장바구니에 항목이 없습니다");
		}
		else {
			menuCartItemList();
			boolean quit = false;
			while (!quit) {
				System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 : ");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				boolean flag = false;
				int numId = -1;
				
				for (int i = 0; i < mCart.mCartCount; i++) {
					if (str.equals(mCart.mCartItem[i].getBookId())) {
						numId = i;
						flag = true;
						break;
					}
				}
				
				if (flag) {
					System.out.println("장바구니의 항목을 삭제하시겠습니까? Y | N");
					str = input.nextLine();
					if (str.toUpperCase().equals("Y")) {
						System.out.println(mCart.mCartItem[numId].getBookId() + 
								"장바구니에서 도서가 삭제되었습니다.");
						mCart.removeCart(numId);
					}
					quit = true;
				}
				else {
					System.out.println("다시 입력해주세요.");
				}
			}
		}
		
	}
	
	public static void menuCartBill() {
		System.out.println("7. 영수증 표시하기: ");
	}
	
	public static void menuExit() {
		System.out.println("8. 종료");
	}
	
	//도서 정보를 저장하는 메소드
	public static void BookList(Book[] bookList) {
		
		bookList[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000);
		bookList[0].setAuthor("송미영");
		bookList[0].setDescroption("단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍");
		bookList[0].setCategory("IT전문서");
		bookList[0].setReleaseDate("2018/10/08");	
		
		bookList[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000);
		bookList[1].setAuthor("우재남");
		bookList[1].setDescroption("실습 단계별 명쾌한 멘토링");
		bookList[1].setCategory("IT전문서");
		bookList[1].setReleaseDate("2022/01/22");
		
		bookList[2] = new Book("ISBN1236", "스크래치", 22000);			
		bookList[2].setAuthor("고광일");		
		bookList[2].setDescroption("컴퓨팅 사고력을 키우는 블록 코딩");		
		bookList[2].setCategory("컴퓨터입문");		
		bookList[2].setReleaseDate("2019/06/10");				
		
	}	
	
	//장바구니에 동일 항목이 있는지 검사하는 메소드
	public static boolean isCartInBook(String bookId) {

		return mCart.isCartInBook(bookId);
	}
	
	//관리자 로그인 정보를 확인하는 메소드
	public static void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요");
		
		Scanner input = new Scanner(System.in);
		System.out.print("아이디: ");
		String adminId = input.next();
		
		System.out.print("비밀번호: ");
		String adminPw = input.next();
		
		Admin admin = new Admin(mUser.getName(), mUser.getPhone());
		if (adminId.equals(admin.getId()) && adminPw.equals(admin.getPassword())) { 
			System.out.println("이름 " + admin.getName() + " 연락처 " + admin.getPhone());
			System.out.println("아이디 " + admin.getId() + " 비밀번호 " + admin.getPassword());
		}
		else 
			System.out.println("관리자 정보가 일치하지 않습니다.");
		
	}
	
}
