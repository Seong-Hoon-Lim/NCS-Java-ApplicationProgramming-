package com.kudangtang.banking.service;

import com.kudangtang.banking.domain.Customer;

public class CustomerServiceImplTest {

	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
		service.addCustomer("유비", "123456-7890123", "010-1234-1111");
		service.addCustomer("관우", "123465-8790123", "010-1234-2222");
		service.addCustomer("장비", "123546-7809123", "010-1234-3333");
		service.addCustomer("조조", "124356-7890213", "010-1234-4444");
		
		Customer customer = service.getCustomerBySsn("900001-1234567");
		System.out.println(customer);

	}

}
