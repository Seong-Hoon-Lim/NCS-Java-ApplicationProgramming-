package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.dao.CustomerDao;
import com.kudangtang.banking.domain.Customer;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerServiceImpl cs = new CustomerServiceImpl();
	private CustomerDao customerDao;
	
	private CustomerServiceImpl() {
		customerDao = new CustomerDao();
	}
	
	public CustomerServiceImpl(DataSource dataSource) {
		customerDao = new CustomerDao(dataSource);
	}
	
//	public CustomerServiceImpl(CustomerDao customerDao) {
//		this.customerDao = customerDao;
//	}
	
	public static CustomerService getInstance() {
		return cs;
	}
	
	
	/**
	 * 고객 등록 기능
	 * @param customer
	 */	
	public void addCustomer(String name, String ssn, String phone, String tel, 
			String userId, String passwd, String email) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(name);
		customer.setSsn(ssn);
		customer.setPhone(phone);
		customer.setTel(tel);
		customer.setUserId(userId);
		customer.setPasswd(passwd);
		customer.setEmail(email);
		
		addCustomer(customer);	
	}	
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	/**
	 * 로그인 기능
	 * @param id
	 * @param passwd
	 */
	@Override
	public Customer getUser(String id, String passwd) {
		return customerDao.findUser(id, passwd);

	}

	/**
	 * 고객 정보 주민번호로 조회 기능
	 * @param ssn
	 * @return
	 */
	@Override
	public Customer getCustomerBySsn(String ssn) {
		// TODO Auto-generated method stub
		return customerDao.findCustomerBySsn(ssn);
	}

	/**
	 * 모든 고객 리스트 조회 기능
	 * @return
	 */
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.findAllCustomerList();
	}

}
