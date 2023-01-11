package com.kudangtang.jv200.mod006;

public class EqualsTest2 {
	public static void main(String[] args) {
		
		/**
		 * 직원의 name, salary, birthDate가 동일하면 같은 직원이 되도록
		 * equals() 메소드를 오버라이딩 하세요.
		 * ex.
		 * Employee e = new Employee("유비", 1000.0, 2000-05-10);
		 * Employee e2 = new Employee("유비", 1000.0, 2000-05-10);
		 * if(e == e2) => false
		 * if(e.equals(e2)) => true
		 */
		
		Employee e1 = new Employee("유비", 1000.0, new MyDate(01,01,2000));
		Employee e2 = new Employee("유비", 1000.0, new MyDate(01,01,2000));
		
		
		if (e1.equals(e2) == true) {
			System.out.println("직원 e와 e2는 같은 직원입니다.");
		}
		else {
			System.out.println("직원 e와 e2는 같은 직원이 아닙니다.");
		}

	}
}
