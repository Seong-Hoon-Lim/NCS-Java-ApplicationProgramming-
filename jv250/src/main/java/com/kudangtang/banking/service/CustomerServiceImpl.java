package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.dao.CustomerDao;
import com.kudangtang.banking.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	public CustomerServiceImpl (CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	//고객 등록하기
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		
	}

	//고객 주민번호 가져오기
	@Override
	public Customer getCustomerBySsn(String ssn) {
		
		return customerDao.findCustomerBySsn(ssn);
	}

	//모든 고객 리스트 가져오기
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.findAllCustomerList();
	}
	
}
