package com.kudangtang.banking.dao;


import java.util.List;

import com.kudangtang.banking.domain.Customer;

public class CustomerDaoTest {
	public static void main(String[] args) {
//		addCustomer();
		//updateCustomer();
		findAllCustomerList();
//		findCustomerBySsn();
	}
	
	public static void addCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer("홍길동", "930001-1901111", "01012433412");
		dao.addCustomer(customer);
		System.out.println("Customer Inserted.... \n");
	}
	
	public static void findAllCustomerList() {
		CustomerDao dao = new CustomerDao();
		List<Customer> list = dao.findAllCustomerList();
		for (Customer custom : list) {
			System.out.println(custom);
		}
	}
	public static void findCustomerBySsn() {
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.findCustomerBySsn("900001-1601111");
		System.out.println(customer);
	}
	
	public static void updateCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer customer = dao.findCustomerBySsn("900001-1601111");
		customer.setName("이순신");
		customer.setPhone("01012443413");
		dao.updateCustomer(customer);
	}
	
	
}
