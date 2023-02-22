package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.dao.CustomerDao;
import com.kudangtang.banking.domain.Customer;

public class CustomerServiceImpl implements CustomerService {

	private static CustomerServiceImpl cs = new CustomerServiceImpl();
	private CustomerDao customerDao;
	
	private CustomerServiceImpl() {
		
	}
	
	public CustomerServiceImpl(DataSource dataSource) {
		customerDao = new CustomerDao(dataSource);
	}
	
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public static CustomerService getCustomerService() {
		return cs;
	}
	
	
	/**
	 * 고객 등록 기능
	 * @param customer
	 */	
	@Override
	public void addCustomer(long id, String name, String ssn, String phone, String tel, 
			String userId, String passwd, String email) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setSsn(ssn);
		customer.setPhone(phone);
		customer.setTel(tel);
		customer.setUserId(userId);
		customer.setPasswd(passwd);
		customer.setEmail(email);
		addCustomer(customer);	
	}	
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	/**
	 * 로그인 기능
	 * @param id
	 */
	@Override
	public Customer getUser(String userId) {
		return customerDao.findUser(userId);

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
	
	/**
	 * 고객정보 수정 기능
	 */
	@Override
	public void updateUser(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateUser(customer);
		
	}
	
	

}
