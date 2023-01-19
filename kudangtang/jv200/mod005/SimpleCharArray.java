package com.kudangtang.jv200.mod005;

public class SimpleCharArray {
	public static void main(String[] args) {
		SimpleCharArray sa = new SimpleCharArray();
		char[] characters = sa.createArray();
		sa.printArray(characters);
	}
	
	/**
	 * 'A'에서 'Z'까지 문자 26개를 가진 char배열 리턴
	 * @return
	 */
	public char[] createArray() {
		char[] s = new char[26];
		for(int i = 0; i < s.length; i++) {
			s[i] = (char)('A' + i);
		}
		return s;
	}
	
	/**
	 * 전달된 배열의 원소를 출력
	 * 
	 * @param array
	 */
	public void printArray(char[] array) {
		System.out.print("[");
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if((i + 1) < array.length) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}
