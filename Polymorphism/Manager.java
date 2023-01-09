package com.kudangtang.jv200.mod006;

public class Manager extends Employee {
	protected String department;
	
	
	public Manager(String name, double salary, MyDate birthDate, String dept) {
		//자식 객체가 만들어지기전에 부모 객체를 먼저 생성
		super(name, salary, birthDate);
		this.department = dept;
		System.out.println("Manager 생성");
		
	}
	
	@Override
	public String getDatails() {
//		return "Name: " + name + 
//				"\nSalary: " + salary + 
//				"\nBirthDate: " + birthDate.getDetails() +
//				"\nDept: " + department;\
		return super.getDatails()
				+ "\nDept: " + department;
	}
	
	public static void main(String[] args) {
		Manager m = new Manager("김과장", 3500.0, new MyDate(8, 11, 1992),"기획부");
		String info = m.getDatails();
		System.out.println("info\n" + info);
		System.out.println("------------------------------------");
		
		Employee e = new Employee("박대리", 3200.0, new MyDate(29, 7, 1986));
		info = e.getDatails();
		System.out.println("info\n" + info);
	}
}
