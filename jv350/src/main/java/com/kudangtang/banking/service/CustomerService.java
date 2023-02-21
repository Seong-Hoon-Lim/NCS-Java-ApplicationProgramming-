package com.kudangtang.banking.service;

import java.util.List;
import com.kudangtang.banking.domain.Customer;

public interface CustomerService {	
		
	/**
	 * 회원 가입 기능
	 * @param customer
	 */
	void addCustomer(long id, String name, String ssn, String phone, String tel, 
			String userId, String passwd, String email);
		
	/**
	 * 로그인 기능
	 * @param id
	 * @param passwd
	 * @return
	 */
	Customer getUser(String userId, String passwd);	
	
	/**
	 * 고객 정보 주민번호로 조회 기능
	 * @param ssn
	 * @return
	 */
	Customer getCustomerBySsn(String ssn);
	
	/**
	 * 모든 고객 리스트 조회 기능
	 * @return
	 */
	List<Customer> getAllCustomers();
	
	/**
	 * 고객 정보 수정 기능
	 * @param customer
	 */
	void updateUser(Customer customer);

}
