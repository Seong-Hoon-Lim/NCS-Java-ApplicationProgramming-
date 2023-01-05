package com.hooney.array;

public class ArrayMain {
	
	public static boolean isEqual(int[] first, int[] second) {
        if (first == second) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
	} 

	public static void main (String[] args) {
		int[] first = { 1, 2, 3 };
        int[] second = { 1, 2, 3 };
        int[] third = { 1, 2, 3, 4 };

        System.out.println("first is equal to second ? " + isEqual(first, second));
        System.out.println("first is equal to third ? " + isEqual(first, third));
        
//		ArrayComparison arrCom = new ArrayComparison(10, 10);
//		int[] arrA = { 1, 2, 3, 4, 5, 6, 7 };
//		int[] arrB = { 1, 2, 3, 4, 5, 8, 9 };
//		arrCom.putValue();
//		arrCom.elementComparison();


	}

}
