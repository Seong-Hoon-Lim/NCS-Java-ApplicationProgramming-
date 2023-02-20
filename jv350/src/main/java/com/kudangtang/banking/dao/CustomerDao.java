package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Customer;

public class CustomerDao {
	private DataSource dataSource;
	
	public CustomerDao() {
		
	}
	
	public CustomerDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 고객 DB 추가 하는 메소드
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone, tel, userId, passwd, email, regDate)" +
						"VALUES (?,?,?,?,?,?,?,?)";
		try (Connection con = dataSource.getConnection();
				 PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				pstmt.setString(4, customer.getTel());
				pstmt.setString(5, customer.getUserId());
				pstmt.setString(6, customer.getPasswd());
				pstmt.setString(7, customer.getEmail());
				pstmt.setString(8, customer.getRegDate());
				pstmt.executeUpdate();
			}
		catch(Exception e) {
			e.printStackTrace();
		}				
		
	}
	
	/**
	 * 고객 DB 에 저장된 유저 중 해당하는 유저가 있는지 
	 * 확인하고 가져오는 메소드
	 * @param id
	 * @param passwd
	 * @return
	 */
	public Customer findUser(String id, String passwd) {
		String sql = "SELECT cid, name, ssn, phone, tel, userId, passwd, email, regDate " +
						"FROME Customer WHERE userId=? AND passwd=?";
		Customer customer = null;
		
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery();) {			
			if(rs.next()) {
				customer = new Customer();
				customer.setCid(rs.getLong("cid"));
				customer.setName(rs.getString("name"));
				customer.setSsn(rs.getString("ssn"));
				customer.setPhone(rs.getString("phone"));
				customer.setTel(rs.getString("tel"));
				customer.setUserId(rs.getString("userId"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setEmail(rs.getString("email"));
				customer.setRegDate(rs.getString("regDate"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public Customer findCustomerBySsn(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 고객 DB 에서 모든 고객 리스트를 가져오는 메소드
	 * @return
	 */
	public List<Customer> findAllCustomerList() {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<>();
		String sql = "SELECT * FROM Customer";
		Customer customer = null;
		
		try (Connection con = dataSource.getConnection();
				 PreparedStatement pstmt = con.prepareStatement(sql);
				 ResultSet rs = pstmt.executeQuery();) {	
			while(rs.next()) {
				customer = new Customer();
				customer.setCid(rs.getLong("cid"));
				customer.setName(rs.getString("name"));
				customer.setSsn(rs.getString("ssn"));
				customer.setPhone(rs.getString("phone"));
				customer.setTel(rs.getString("tel"));
				customer.setUserId(rs.getString("userId"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setEmail(rs.getString("email"));
				customer.setRegDate(rs.getString("regDate"));
				list.add(customer);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	

}
