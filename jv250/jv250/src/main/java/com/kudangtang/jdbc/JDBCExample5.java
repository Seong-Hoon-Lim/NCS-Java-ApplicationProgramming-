package com.kudangtang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * DELETE Customer SET ~
 * @author "SeongHoon"
 *
 */

public class JDBCExample5 {
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
			
			String sql = "DELETE FROM Customer WHERE cid=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, 1016);
			pstmt.executeUpdate();
			System.out.println("EXECUTED QUERY ---> " + sql);
			System.out.println("\nDeleted.... \n");
			
			pstmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
