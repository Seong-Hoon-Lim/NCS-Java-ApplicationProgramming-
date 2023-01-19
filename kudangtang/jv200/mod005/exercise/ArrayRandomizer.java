package com.kudangtang.jv200.mod005.exercise;

import java.util.Arrays;

/**
 * 특정 확률에 근거한 랜덤 결과값을 리턴
 * 70%, 50%, 30%, 10%, 1%, 0.1%
 * @author Sage R Lee
 *
 */
public class ArrayRandomizer {
	private int[] STAT = new int[] {700, 500, 300, 100, 40, 10, 1};
	private int[] statIndexes;
	
	public ArrayRandomizer() {
		int len = 0;
		for(int num : STAT) {
			len += num;
		}
		statIndexes = new int[len];
		
		int index = 0, num = 0;
		for(int bulk : STAT) {
			for(int i = 0; i < bulk; i++) {
				statIndexes[index] = num;
				index++;
			}
			num++;
		}
	}
	
	public int randomItem() {
		return (int)(Math.random() * (statIndexes.length - 1));
	}
	
	
	public static void main(String[] args) {
		ArrayRandomizer r = new ArrayRandomizer();
		System.out.println("r.statIndexes의 크기: " + r.statIndexes.length);
		System.out.println(Arrays.toString(r.statIndexes));
		
		int num = 0;
		int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;
		for(int i = 0; i < 1000; i++) {
			num = r.randomItem();
			if(num < 700) {
				zero++;
			}else if(num >= 700 && num < (700 + 500)) {
				one++;
			}else if(num >= (700 + 500) && num < (700 + 500 + 300)) {
				two++;
			}else if(num >= (700 + 500 + 300) && num < (700 + 500 + 300 + 100)) {
				three++;
			}else if(num >= (700 + 500 + 300 + 100) && num < (700 + 500 + 300 + 100 + 40)) {
				four++;
			}else if(num >= (700 + 500 + 300 + 100 + 40) && num < (700 + 500 + 300 + 100 + 40 + 10)) {
				five++;
			}else  {
				six++;
			}
		}
		System.out.println("zero = " + zero);
		System.out.println("one = " + one);
		System.out.println("two = " + two);
		System.out.println("three = " + three);
		System.out.println("four = " + four);
		System.out.println("five = " + five);
		System.out.println("six = " + six);
	}
}
