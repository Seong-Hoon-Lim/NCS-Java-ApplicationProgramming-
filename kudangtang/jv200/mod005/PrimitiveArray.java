package com.kudangtang.jv200.mod005;

public class PrimitiveArray {
	public static void main(String[] args) {
		int[] ages;
		ages = new int[5];
		ages[0] = 19;
		ages[1] = 42;
		ages[2] = 92;
		ages[3] = 33;
		ages[4] = 46;
		
		int[] ages2 = new int[]{19, 42, 92, 33, 46};
		for(int i = 0; i < ages.length; i++) {
			System.out.println("[" + i + "] = " + (ages[i] == ages2[i]));
		}
	}
}
