package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.domain.Customer;

public interface CustomerService {
	
	//고객 등록하기
	void addCustomer(Customer customer);
	
	//고객 주민번호 가져오기
	Customer getCustomerBySsn(String ssn);
	
	//모든 고객 리스트 가져오기
	List<Customer> getAllCustomers();
	
	//

}
