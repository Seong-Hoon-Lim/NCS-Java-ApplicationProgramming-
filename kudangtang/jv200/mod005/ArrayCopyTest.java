package com.kudangtang.jv200.mod005;

public class ArrayCopyTest {
	public static void main(String[] args) {
		int[] srcArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] destArray = new int[4];
		
		System.arraycopy(srcArray, 5, destArray, 2, 2);
		for(int i = 0; i < srcArray.length; i++) {
			System.out.print(srcArray[i] + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < destArray.length; i++) {
			System.out.print(destArray[i] + "\t");
		}
	
	}
}
