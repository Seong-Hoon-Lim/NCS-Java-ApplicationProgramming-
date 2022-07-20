package org.basicexamplesentence.classobject;

//	간단한 자판기 프로그램 (간단한 클래스 생성 연습)
class SimpleVendingMachine {

	public static void main(String[] args) {
		VDM vdm = new VDM();
		vdm.Pay();
	}
}

class VDM {
	int drink = 700;
	int money = 3000;
	
	void Pay() {
		for (int count=0; count<4; count++) {
			System.out.println("음료수는 = "+count+"개, 잔돈 = "+money+"원");
			money -= drink;
		}
	}
}
