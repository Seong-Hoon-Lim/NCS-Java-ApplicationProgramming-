package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kudangtang.banking.domain.Customer;

public class CustomerDaoTest {
	public static void main(String[] args) {
		addCustomer();
	
		
		String sql = "INSERT INTO Customer(name, ssn, phone) VALUES (?, ?, ?)";
		Connection con = DriverManager.getConnection(url, id, passwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "홍길동");
		pstmt.setString(2, "930001-1901111");
		pstmt.setString(3, "01012433412");
		pstmt.executeUpdate();
		System.out.println("EXECUTED QUERY ---> " + sql);
		System.out.println("\nInserted.... \n");
		
		pstmt.close();
		con.close();
	}
	
}
