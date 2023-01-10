package com.kudangtang.jv200.mod006;

public class EqualsTest {
	public static void main(String[] args) {
		NoteBook noteBook = new NoteBook();
		noteBook.setName("Apple MacBook Pro");
		noteBook.setInch(15.6);
		noteBook.setPrice(3500.0);
		
		NoteBook noteBook2 = new NoteBook();
		noteBook2.setName("Apple MacBook Pro");
		noteBook2.setInch(15.6);
		noteBook2.setPrice(3500.0);
		
		if (noteBook == noteBook2) {
			System.out.println("== is true");
		}
		else {
			System.out.println("== is false");
		}
		
		if (noteBook.equals(noteBook2)) {
			System.out.println("equals is true");
		}
		else {
			System.out.println("equals is false");
		}
		
		String str = new String("유비");
		String str2 = new String("유비");
		
		if (str == str2) {
			System.out.println("== is true");
		}
		else {
			System.out.println("== is false");
		}
		
		if (str.equals(str2)) {
			System.out.println("equals is true");
		}
		else {
			System.out.println("equals is false");
		}
		System.out.println("-------------------------");
		
		String str3 = "유비";
		String str4 = "유비";
		
		if (str3 == str4) {
			System.out.println("== is true");
		}
		else {
			System.out.println("== is false");
		}
		
		if (str3.equals(str4)) {
			System.out.println("equals is true");
		}
		else {
			System.out.println("equals is false");
		}
		
	}
}
