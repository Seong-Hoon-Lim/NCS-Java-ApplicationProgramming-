package com.kudangtang.jv200.mod006;

public class PolymorphismTest {
	public static void main(String[] args) {
		Product p = new NoteBook();
		p.setName("Apple MacBook Pro");
		p.setPrice(3500.0);
		//NoteBook의 사이즈(inch)는 어떻게?
		if (p instanceof NoteBook) {
			NoteBook n = (NoteBook)p;	//다운캐스팅 - 부모에서 자식으로
			n.setInch(15.6);
		}
		//name: Apple MacBook Pro, price: 3500.0, inch: 15.6
		System.out.println(p.getDetails());
	}
	
}
