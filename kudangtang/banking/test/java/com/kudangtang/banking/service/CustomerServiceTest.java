package com.kudangtang.banking.service;

import com.kudangtang.banking.domain.Customer;

public class CustomerServiceTest {
	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
		service.addCustomer("유비", "901212-9012121", "010-1234-1234");
		service.addCustomer("관우", "911212-911212", "010-2345-2345");
		service.addCustomer("장비", "921212-921212", "010-3456-3456");
		service.addCustomer("조조", "801212-801212", "010-4567-4567");
		
		Customer customer = service.getCustomerBySsn("901214-9012121");
		System.out.println(customer);
	}
}
