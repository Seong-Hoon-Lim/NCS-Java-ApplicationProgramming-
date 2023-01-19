package com.kudangtang.jv200.mod006;

public class Manager extends Employee{
	protected String department;
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		super(name, salary, birthDate);
		this.department = dept;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails()
				+ "\ndepartment: " + department;
	}
	public static void main(String[] args) {
		Manager m = new Manager("유비", 3000.0, new MyDate(10, 5, 2000), "영업부");
		String info = m.getDetails();
		System.out.println(info);
		System.out.println("--------------------------------------------");
		Employee e = new Employee("관우", 2000.0, new MyDate(22, 8, 2001));
		info = e.getDetails();
		System.out.println(info);
		
	}
}
