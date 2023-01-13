package com.kudangtang.banking.service;

import java.util.Arrays;
import java.util.Random;

public class AccountNumberGenerator {
	
	public String accountNumberGenerate() {
		
		String generate = "";
		String generate2 = "";
		
		Random random = new Random();
		int[] accountNum = new int[4];
		int[] accountNum2 = new int[4];
		
		for (int i = 0; i < accountNum.length; i++) {
			accountNum[i] = random.nextInt(10)+0;
		}
		
		for (int i = 0; i < accountNum2.length; i++) {
			accountNum2[i] = random.nextInt(10)+0;
		}
		
		generate = Arrays.toString(accountNum);
		generate2 = Arrays.toString(accountNum2);
		String result1 = generate.replaceAll("[^\\d]", "");
		String result2 = generate2.replaceAll("[^\\d]", "");
		String result = result1 + "-" + result2;
		return result;
	} 

	public static void main(String[] args) {
		
	}
}
