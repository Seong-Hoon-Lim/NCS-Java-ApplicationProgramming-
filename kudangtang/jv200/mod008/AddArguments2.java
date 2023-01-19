package com.kudangtang.jv200.mod008;
/**
 * java AddArguments 1 2 3 4
 * 
 * @author Sage R Lee
 *
 */
public class AddArguments2 {
	public static void main(String[] args) {
		try {
			int sum = 0;
			for(String arg : args) {
				sum += Integer.parseInt(arg);
			}
			System.out.println("sum = " + sum);
		}catch(NumberFormatException e) {
			System.err.println("특정 아규먼트가 숫자가 아닙니다.");
		}
	}
}
