package com.kudangtang.banking.service;

import com.kudangtang.banking.dao.CustomerDao;
import com.kudangtang.banking.domain.Customer;

public class CustomerServiceTest {
	
	public static final CustomerService CUSTOMER_SERVICE = new CustomerServiceImpl(new CustomerDao());
	
	public static void main(String[] args) {
//		CustomerService customerService = new CustomerServiceImpl(new CustomerDao());
//		Customer customer = new Customer("동탁", "881011-1234567", "01045457788");
		Customer customer = new Customer("여포", "901001-1234567", "01045548788");
		CUSTOMER_SERVICE.addCustomer(customer);
		System.out.println("Customer Inserted.... \n");
	}
}
