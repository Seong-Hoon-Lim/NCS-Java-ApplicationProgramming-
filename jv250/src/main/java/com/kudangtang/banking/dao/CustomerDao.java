package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kudangtang.banking.domain.Customer;

/**
 * Dao = DAO
 * Data Access Object
 * 
 * @author "SeongHoon"
 *
 */
public class CustomerDao {

	//고객 DB 추가하는 메소드
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone) VALUES (?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				pstmt.executeUpdate();
			}
			/**
			 * 위 단계에서 에러가 발생될 수 있기 때문에 에러가 발생되도
			 * close() 는 실행 되어야 하므로 finally 를 사용
			 */
			finally {
				DataSourceManager.close(pstmt, con);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//고객 DB 리스트를 선택해서 가져오는 메소드
	public List<Customer> findAllCustomerList() {
		List<Customer> list = new ArrayList<>();
		Customer customer = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DataSourceManager.getConnection();
				
				String sql = "SELECT * FROM Customer";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					customer = new Customer(rs.getString("name")
							,rs.getString("ssn"),rs.getString("phone"));
					list.add(customer);
				}
			}
			finally {
				DataSourceManager.close(rs, pstmt, con);			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//고객 DB 중에 ssn을 선택해서 가져오는 메소드
	public Customer findCustomerBySsn(String ssn) {
		Customer customer = null;
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				
				rs = pstmt.executeQuery();								
				if (rs.next()) {
					customer = new Customer(rs.getString("name")
							,rs.getString("ssn"),rs.getString("phone"));
				}				
			}		
			finally {
				DataSourceManager.close(rs, pstmt, con);	
			}
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return customer;
	}
	
	//고객 DB를 수정하는 메소드
	public void updateCustomer(Customer customer) {
		try {
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				con = DataSourceManager.getConnection();
				String sql = "UPDATE Customer SET name=?, ssn=?, phone=? WHERE ssn=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				pstmt.setString(4, customer.getSsn());
				pstmt.executeUpdate();
				
			}
			finally {
				DataSourceManager.close(pstmt, con);	
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//고객DB를 삭제하는 메소드
	public void deleteCustomer() {
		Customer customer = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DataSourceManager.getConnection();
				
			
			}
			finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
