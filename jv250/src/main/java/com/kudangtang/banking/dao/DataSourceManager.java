package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceManager {
	private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";	
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/jv250?serverTimeoutzone=Asia/Seoul";	
	private static final String JDBC_USER="jv250";	
	private static final String JDBC_PASSWD="jv250";
	
	//static 
	static {
		try {	
			Class.forName(JDBC_DRIVER);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
		
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con)
			throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (con != null) {
			con.close();
		}
	}
	
	public static void close(PreparedStatement pstmt, Connection con)
			throws SQLException {
		close(null, pstmt, con);
	}
	
	public static void close(Connection con)
			throws SQLException {
		close(null, null, con);
	}
	
	public static void main(String[] args) {
		try {
			Connection con = getConnection();
			System.out.println("con is open = " + con);
			close(con);
			System.out.println("con is closed = " + con.isClosed());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
