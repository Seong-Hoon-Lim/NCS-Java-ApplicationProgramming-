package com.kudangtang.jv200.mod004.excersise;

public class AdvancedMuliplyFor {
	
	/**
	 * 
	 * @param parent
	 * @param child
	 */
	public void printMultiply(int parent, int child) {
		for(int i = 1; i <= child; i++){
			for(int j = 2; j <= parent; j++){
				System.out.print(j + "*" + i + "=" + i*j + "   \t" );
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		AdvancedMuliplyFor m = new AdvancedMuliplyFor();
		m.printMultiply(15, 29);
	}
}
