package com.kudangtang.jv200.mod006;

public class Employee {
	protected String name;
	protected double salary;
	protected MyDate birthDate;
	
	public Employee(Object obj) {
		
	}
	
	public Employee(String name, double salary, MyDate birthDate) {
//		System.out.println("Employee 생성");
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
		
		String salary_s = "" + salary;
		String birthDate_s = "" + birthDate.getDetails();
		
//		System.out.println(name);
//		System.out.println(salary_s);
//		System.out.println(birthDate_s);
	}
	
//	public boolean equals(Object obj) {
//		
//		Employee e = (Employee) obj;
//		if (e.name == this.name && e.salary == this.salary 
//				&& e.birthDate == this.birthDate) {
//			return true;
//		}
//		else return false;
//	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee e = (Employee)o;
			if (e.name.equals(this.name) && e.salary == this.salary 
					&& e.birthDate.equals(this.birthDate)) {
						return true;
					}
				}
			return false;
	}
	
//	@Override
//	public String toString() {
//		
//		return "Name: " + name + "\nSalary: " + salary 
//				+ "\nBirthDate: " + birthDate.getDetails();
//	}

	public String getDatails() {
		
		return "Name: " + name + "\nSalary: " + salary 
				+ "\nBirthDate: " + birthDate.getDetails();
	}
}