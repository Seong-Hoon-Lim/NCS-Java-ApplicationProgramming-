package com.kudangtang.jv200.mod006;

public class Employee {
	protected String name;
	protected double salary;
	protected MyDate birthDate;
	
//	public Employee() {
//		
//	}
	
	public Employee(String name, double salary, MyDate birthDate) {
		System.out.println("Employee 생성");
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public String getDatails() {
		return "Name: " + name + "\nSalary: " + salary 
				+ "\nBirthDate: " + birthDate.getDetails();
	}
	
}
