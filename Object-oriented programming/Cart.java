package com.kudangtang.jv200.mod006;

public class Cart {
	Product[] products = new Product[2];
	
	public void add(Product p) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = p;
				break;
			}
		}
	}
	
	public Product[] getProducts() {
		return this.products;
	}
	
	public static void main(String[] args) {
		Cart cart = new Cart();
		//NoteBook 생성
		NoteBook noteBook = new NoteBook();
		noteBook.setName("Apple MacBook pro");
		noteBook.setInch(15.6);
		noteBook.setPrice(3500.0);
		cart.add(noteBook);
		//SmartPhone 생성/추가
		SmartPhone phone = new SmartPhone();
		phone.setName("Samsung Gallaxy S22");
		phone.setOs("Android 11");
		phone.setPrice(110);
		cart.add(phone);
		//cart 확인
		Product[] products = cart.getProducts();
		for (Product p : products) {
			System.out.println(p.getDetails());
		}
		
	}
}
