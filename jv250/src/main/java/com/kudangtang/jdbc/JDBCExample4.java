package com.kudangtang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * UPDATE Customer SET ~
 * @author "SeongHoon"
 *
 */

public class JDBCExample4 {
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
			
			String sql = "UPDATE Customer SET name=? WHERE name=? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "조조");
			pstmt.setString(2, "홍길동");
			pstmt.executeUpdate();
			System.out.println("EXECUTED QUERY ---> " + sql);
			System.out.println("\nUpdated.... \n");
			
			pstmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
