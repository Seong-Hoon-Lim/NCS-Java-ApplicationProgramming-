package org.basicexamplesentence.CollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

// 컬렉션 프레임워크 중 해쉬맵 연습

//	■ 고객관리 프로그램:
//	 HashMap 를 활용 사용자의 이름과 전화번호를 저장하는 전화번호부 생성
//
//	■ 프로그램 기능
//	1) 고객 저장
//	2) 고객 검색
//	3) 전체보기
//	4) 끝내기
//	
//	※ 주의
//	- 모든 메서드에서 알아야 할 필드: 클래스 영역 내에서 생성
//	- main은 static 영역이므로 main 영역에서도 사용하기 위해 static 변수로 저장


public class PhoneBookMain {
	static HashMap<String, String> hm = new HashMap<String,String>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice;
		while (true) {
			System.out.println("☆★☆★☆★전화번호부☆★☆★☆★");
			System.out.println("1. 고객 정보 저장");
			System.out.println("2. 고객 정보 검색");
			System.out.println("3. 고객 정보 출력");
			System.out.println("4. 끝내기");
			System.out.print("번호 입력: ");
			choice = sc.nextInt();
			if (choice==1) {
				System.out.println("----------고객 정보 저장----------");
				insert();
			}
			else if (choice==2) {
				System.out.println("----------고객 정보 검색----------");
				search();
			}
			else if (choice==3) {
				System.out.println("----------고객 정보 출력----------");
				show();
			}
			else if (choice==4) {
				System.out.println("완료되었습니다. 프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
			}
		}
		
	}
	public static void insert() {
		String name,phone;
		System.out.print("저장할 고객의 이름: ");
		name = sc.next();
		//name이 key이므로, 중복 허용 불가
		if (hm.containsKey(name)) {
			System.out.println("이미 존재하는 이름입니다.");
			return;
		}
		else {
			System.out.print("저장할 고객의 번호: ");
			phone = sc.next();
			hm.put(name, phone);
			System.out.println("저장 완료!");
		}
	}
	public static void search() {
		String searchName;
		System.out.print("검색할 이름: ");
		searchName = sc.next();
		//searchName이 hm에 존재해야 검색 가능!
		if (hm.containsKey(searchName)) {
			System.out.println("검색 완료!");
			System.out.println("검색된 전화번호: "+hm.get(searchName));
		}
		else {
			System.out.println("검색된 이름이 없습니다.");
		}
	}
	public static void show() {
		Set<String> keyset = hm.keySet();
		Iterator i = keyset.iterator();
		while (i.hasNext()) {
			String curName = (String)i.next();
			System.out.println("name :"+curName+", phone: "+hm.get(curName));
		}
		
	}
}
