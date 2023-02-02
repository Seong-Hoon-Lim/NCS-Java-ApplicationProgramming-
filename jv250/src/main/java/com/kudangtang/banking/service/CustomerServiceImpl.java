package com.kudangtang.banking.service;

import java.util.List;

import com.kudangtang.banking.dao.CustomerDao;
import com.kudangtang.banking.domain.Customer;

	public class CustomerServiceImpl implements CustomerService {
		
		/**
		 * 싱글톤 기법
			객체가 한번만 생성 되고 이후에 추가로 생성이 불필요한 경우
			해당 객체의 클래스에 private 접근제어자 static 키워드를 붙여
			생성자를 생성하고 생성된 객체를 다시 public 접근제어자 static
			키워드를 붙여 getInstance() 메서드를 생성하여 객체를 return 받는 것
			
			고정된 메모리 영역을 얻으면서 한번의 new 연산으로 인스턴스를 사용하기 때문에
			메모리 낭비를 방지할 수 있다
			
			인스턴스가 절대적으로 한 개만 존재하는 것을 보증하고 싶을 경우 사용한다
		 */		
		private static CustomerServiceImpl cs = new CustomerServiceImpl();	
		private CustomerDao customerDao;
		
		private CustomerServiceImpl() {
			customerDao = new CustomerDao();
		}
		
		public CustomerServiceImpl (CustomerDao customerDao) {		
			this.customerDao = customerDao;
		}
		
		public static CustomerService getInstance() {
			return cs;
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
