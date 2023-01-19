package com.kudangtang.jv200.mod008;
/**
 * java AddArguments 1 2 3 4
 * 
 * @author Sage R Lee
 *
 */
public class AddArguments {
	public static void main(String[] args) {
		int sum = 0;
		for(String arg : args) {
			sum += Integer.parseInt(arg);
		}
		System.out.println("sum = " + sum);
	}
}
