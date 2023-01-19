package com.kudangtang.jv200.mod006;

public class EmployeeEqualsTest {
	public static void main(String[] args) {
		Employee e = new Employee("유비", 3000.0, new MyDate(1, 1, 2000));
		Employee e2 = new Employee("유비", 3000.0, new MyDate(1, 1, 2000));
		System.out.println(e.equals(e2));
		System.out.println(e);
		System.out.println(e.toString());
	}
}
