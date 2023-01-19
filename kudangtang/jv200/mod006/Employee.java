package com.kudangtang.jv200.mod006;

public class Employee {
	protected String name;
	protected double salary;
	protected MyDate birthDate;
	
	public Employee(String name, double salary, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Employee) {
			Employee e = (Employee)o;
			if(e.name.equals(this.name) && e.salary == this.salary 
					&& e.birthDate.equals(this.birthDate)) {
				return true;
			}
					
		}
		return false;
	}
	
	public String getDetails() {
		return "Name: " + name + "\nSalary: " + salary 
				+ "\nBirthDate: " + birthDate.getDetails();
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nSalary: " + salary 
				+ "\nBirthDate: " + birthDate.getDetails();
	}
}
