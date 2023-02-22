package com.kudangtang.banking.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	String sql = "INSERT INTO Customer(name, ssn, phone, tel, userId, passwd, email)" 
					+ "VALUES (?,?,?,?,?,?,?)";
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				pstmt.setString(4, customer.getTel());
				pstmt.setString(5, customer.getUserId());
				pstmt.setString(6, customer.getPasswd());
				pstmt.setString(7, customer.getEmail());
//				pstmt.setString(8, customer.getRegDate());
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
	 * @return
	 */
	public Customer findUser(String userId) {
		String sql = "SELECT * FROM Customer WHERE userId=? AND passwd=?";
		Customer customer = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;	
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				
				rs = pstmt.executeQuery();
		
				if(rs.next()) {
					customer = new Customer();
					customer.setId(rs.getLong("id"));
					customer.setName(rs.getString("name"));
					customer.setSsn(rs.getString("ssn"));
					customer.setPhone(rs.getString("phone"));
					customer.setTel(rs.getString("tel"));
					customer.setUserId(rs.getString("userId"));
					customer.setPasswd(rs.getString("passwd"));
					customer.setEmail(rs.getString("email"));
//					customer.setRegDate(rs.getString("regDate"));
				}
			}
			finally {
				DataSource.close(rs, pstmt, con);
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
		String sql = "SELECT * FROM Customer ORDER BY id";
		Customer customer = null;
		
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery();) {	
			while(rs.next()) {
				customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setSsn(rs.getString("ssn"));
				customer.setPhone(rs.getString("phone"));
				customer.setTel(rs.getString("tel"));
				customer.setUserId(rs.getString("userId"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setEmail(rs.getString("email"));
//				customer.setRegDate(rs.getString("regDate"));
				list.add(customer);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * DB에서 클라이언트가 입력한 고객 정보를 수정하는 기능
	 * @param customer
	 */
	public void updateUser(Customer customer) {
		String sql = "UPDATE Customer SET name=?, phone=?, tel=?, passwd=?, email=? " 
							+ "WHERE id=?";
		try(Connection con = dataSource.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getPhone());
			pstmt.setString(3, customer.getTel());
			pstmt.setString(4, customer.getPasswd());
			pstmt.setString(5, customer.getEmail());
			pstmt.setLong(6, customer.getId());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}		

}
