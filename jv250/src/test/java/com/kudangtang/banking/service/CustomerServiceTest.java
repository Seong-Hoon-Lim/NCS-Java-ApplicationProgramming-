package com.kudangtang.banking.service;

import com.kudangtang.banking.dao.CustomerDao;
import com.kudangtang.banking.domain.Customer;

public class CustomerServiceTest {	
	private static CustomerService custService = CustomerServiceImpl.getInstance();
	
	public static void main(String[] args) {
		addCustomer();
	}
	
	public static void addCustomer() {
//		CustomerService customerService = new CustomerServiceImpl(new CustomerDao());
//		Customer customer = new Customer("동탁", "881011-1234567", "01045457788");
//		Customer customer = new Customer("여포", "901001-1234567", "01045548788");
		Customer customer = new Customer("제갈량", "900302-1234567", "01035538778");		
		custService.addCustomer(customer);
		System.out.println("Customer Inserted.... \n");
	}
}
