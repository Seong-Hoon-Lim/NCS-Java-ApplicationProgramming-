package com.kudangtang.jv200.mod006;

public class Product {
	protected String name;
	protected double price;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public String getDetails() {
		return "name: " + name + ", price: " + price;
	}
}
