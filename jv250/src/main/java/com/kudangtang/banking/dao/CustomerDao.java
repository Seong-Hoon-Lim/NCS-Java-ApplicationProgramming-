package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.kudangtang.banking.domain.Customer;

/**
 * Dao = DAO
 * Data Access Object
 * 
 * @author "SeongHoon"
 *
 */
public class CustomerDao {
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimeoutzone=Asia/Seoul";
	static final String JDBC_USER = "jv250";
	static final String JDBC_PASSWD = "jv250";
	
	
	
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}

	public static String getJdbcUrl() {
		return JDBC_URL;
	}

	public static String getJdbcUser() {
		return JDBC_USER;
	}

	public static String getJdbcPasswd() {
		return JDBC_PASSWD;
	}

	public CustomerDao() {
		
		try {	
			Class.forName(JDBC_DRIVER);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone) VALUES (?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getSsn());
				pstmt.setString(3, customer.getPhone());
				pstmt.executeUpdate();
			}
			finally {
				pstmt.close();
				con.close();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
