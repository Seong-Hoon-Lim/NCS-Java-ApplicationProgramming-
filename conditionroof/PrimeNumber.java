package com.hooney.conditionloop;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber {
	//소수 (prime number) 구하는 알고리즘
	/**
	 *  1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
		2. 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다
		자기 자신을 제외한 2의 배수를 모두 지운다.
		남아 있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
		자기 자신을 제외한 3의 배수를 모두 지운다.
		남아 있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
		자기 자신을 제외한 5의 배수를 모두 지운다.
		위 과정을 반복한다.
	 */
	Scanner scanner = new Scanner(System.in);
	public void calculator() {
		System.out.print("소수를 구할 대상 숫자를 입력하세요: ");
		//소수를 구할 대상 숫자 입력
		int targetNum = scanner.nextInt();
		
		//ArrayIndexOutOfBoundsException 을 사전에 방지위해 -1 만큼 배열 지정
		boolean prime[] = new boolean[targetNum+1];
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		
		//소수는 false
		//1은 소수가 아니므로 제외
		prime[0] = prime[1] = true;
		
		for (int i=2; i*i<=targetNum; i++) {
			//prime[i]가 소수인지 판별
			if (!prime[i]) {
				//prime[j] 소수가 아닌 수를 표시
				for (int j=i*i; j<=targetNum; j+=i) {
					prime[j] = true;
				}
			}
			
		}
		//소수 출력
		for (int i=1; i<=targetNum; i++) {
			if (!prime[i]) {
				primeNumbers.add(i);
			}
		}
		System.out.println("소수의 개수는 " + primeNumbers.size());
		//소수 확인		
		
	}
}
