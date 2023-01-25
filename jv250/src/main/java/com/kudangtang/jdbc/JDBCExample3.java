package com.kudangtang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * INSERT INTO Customer
 * @author "SeongHoon"
 *
 */

public class JDBCExample3 {
	public static void main(String[] args) {
		String driver="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimeoutzone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---> " + driver);
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---> " + url);
			
			String sql = "INSERT INTO Customer(name, ssn, phone) VALUES (?, ?, ?)";
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
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
