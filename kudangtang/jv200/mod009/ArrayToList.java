package com.kudangtang.jv200.mod009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayToList {
	public static void main(String[] args) {
		String[] subjects = {"maths", "english", "history", "physics"};
		//방법1
		ArrayList<String> list = new ArrayList<>();
		for(String subject : subjects) {
			list.add(subject);
		}
		// list 데이터 출력
		for(String subject : list) {
			System.out.println(subject);
		}
		System.out.println("0th element = " + list.get(0));
		System.out.println("--------------------------------");
		//방법2
		list = new ArrayList<>(Arrays.asList(subjects));
		// list 데이터 출력
		for(String subject : list) {
			System.out.println(subject);
		}
		System.out.println("--------------------------------");
		//방법3
		list = new ArrayList<>();
		Collections.addAll(list, subjects);
		// list 데이터 출력
		for(String subject : list) {
			System.out.println(subject);
		}
	}
}
