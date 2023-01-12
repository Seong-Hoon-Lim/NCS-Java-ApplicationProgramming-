package com.kudangtang.banking.service;

import java.util.Arrays;
import java.util.Random;

public class AccountNumberGenerator {
	
	public String accountNumberGenerate() {
		
		String generate = "";
		
		Random random = new Random();
		int[] accountNum = new int[4];
		int[] accountNum2 = new int[4];
		
		for (int i = 0; i < accountNum.length; i++) {
			accountNum[i] = random.nextInt(10)+0;
//			System.out.print(accountNum[i]);
		}
		
//		System.out.print("-");
		
		for (int i = 0; i < accountNum2.length; i++) {
			accountNum2[i] = random.nextInt(10)+0;
//			System.out.print(accountNum2[i]);
		}
		
		generate = Arrays.toString(accountNum) + "-" + Arrays.toString(accountNum2);
		String result = generate.replaceAll("[^\\d]", "");
		return result;
//		return Arrays.toString(accountNum) + "-" + Arrays.toString(accountNum2);
	} 

	public static void main(String[] args) {
		AccountNumberGenerator an = new AccountNumberGenerator();
		System.out.println(an.accountNumberGenerate());
	}
}
