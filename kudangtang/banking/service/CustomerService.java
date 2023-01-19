package com.kudangtang.banking.service;

import java.util.Collection;

import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.exception.CustomerNotFoundException;

public interface CustomerService {
	/**
	 * 전달된 인자로 구성된 Customer 정보 추가
	 * 
	 * @param name
	 * @param ssn
	 * @param phone
	 * @return
	 */
	Customer addCustomer(String name, String ssn, String phone);
	
	/**
	 * 전달된 인자로 구성된 Customer 정보 추가
	 * @param customer
	 * @return
	 */
	Customer addCustomer(Customer customer);
	
	Customer getCustomerBySsn(String ssn) throws CustomerNotFoundException;
	
	Collection<Customer> getAllCustomers();
}
