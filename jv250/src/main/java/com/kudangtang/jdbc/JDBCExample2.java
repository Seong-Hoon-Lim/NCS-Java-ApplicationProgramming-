package com.kudangtang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCExample2 {
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
			
			String sql = "SELECT * FROM Customer";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("EXECUTED QUERY ---> " + sql);
			System.out.println("\nPROCESSING RESULTS : \n");
			while (rs.next()) {
				System.out.println(" CID    : " + rs.getLong("cid"));
				System.out.println(" NAME   : " + rs.getString("name"));
				System.out.println(" SSN    : " + rs.getString("ssn"));
				System.out.println(" PHONE  : " + rs.getString("phone"));
				System.out.println("---------------------------------------");
			}
			rs.close();
			pstmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
