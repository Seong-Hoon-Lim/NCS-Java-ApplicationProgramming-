package com.kudangtang.banking.domain;

import java.util.Random;

public class AccountNumGenerator {
	
	/**
	 * ####-#### 형태의 자리수를 갖는 계좌번호 생성
	 * 
	 * @return
	 */
	public static String generateAccountNum() {
		int digitNum = 9999;	// 4자리수
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for(int i = 0 ; i < 2; i++) {
			num = random.nextInt(digitNum + 1);
			//digitNum보다 작은 num은 제외
			while(num < 1000) {
				num  = random.nextInt(digitNum + 1);
			}
			sb.append(String.valueOf(num));
			if(i < 1) {
				sb.append("-");
			}
		}
		return sb.toString();
	}
}
