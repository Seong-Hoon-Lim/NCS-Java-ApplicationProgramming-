package com.kudangtang.jv200.mod004.excersise;

public class PrimeNumber {
	public static void main(String[] args) {
		int maxNum = 1000;
		boolean isPrimeNumber = false;
		int count = 0;
		long start = System.currentTimeMillis();
		
		for(int i = 2; i < maxNum + 1; i++){
			isPrimeNumber = true;
			//임의의 수(i)를 2부터 (임의의 수 - 1) 만큼 모두 나눠서 
			//한번이라도 0이 되면 소수가 아니다.
			for(int j = 2; j < i ; j++){
				if(i % j == 0){
					isPrimeNumber = false;
					break;	
				}
			}
			if(isPrimeNumber){
				System.out.println(i + " is a prime number");
				count++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("\nTotal count of prime numbers is "+ count);
		System.out.println("Processed Time is "+ (end-start)/1000.0+"sec");
	}
}
