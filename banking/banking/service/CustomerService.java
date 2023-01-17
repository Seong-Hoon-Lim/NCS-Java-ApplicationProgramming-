package com.kudangtang.banking.service;

import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.exception.CustomerNotFoundException;

public interface CustomerService {
	/**
	 * 전달된 인자로 구성된 Customer 정보 추가
	 * 
	 * @param name
	 * @param ssn
	 * @param phone
	 * @retutn
	 */
	Customer addCustomer(String name, String ssn, String phone);
	

	/**
	 * 전달된 인자로 구성된 Customer 정보 추가
	 * @param customer
	 * @return
	 */
	Customer addCustomer(Customer customer);
	
	/**
	 * Customer 정보 중 ssn 정보 가져오기
	 * 일치하는 ssn 정보가 없을 때 CustomerNotFoundException 예외 발생
	 * @return
	 */
	Customer getCustomerBySsn(String ssn) throws CustomerNotFoundException;

}