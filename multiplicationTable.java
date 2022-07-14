package org.basicexamplesentence.loop;

// 구구단 구현
public class multiplicationTable {

	public static void main(String[] args) {
		// i: 2단부터 +1씩 증가 , j: 1~9까지 +1씩 증가 반복 
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf(" %d x %d = %d\n",i ,j ,i*j);
			}
		}

	}

}
