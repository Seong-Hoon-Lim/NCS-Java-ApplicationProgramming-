package com.kudangtang.jv300.mod011.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataSourceManager {
	private static String JDBC_DRIVER;
	private static String JDBC_URL;
	private static String JDBC_ID;
	private static String JDBC_PW;
	
	public DataSourceManager(String driver, String url, String id, String pw) throws ClassNotFoundException, SQLException{
		DataSourceManager.JDBC_DRIVER = driver;
		DataSourceManager.JDBC_URL = url;
		DataSourceManager.JDBC_ID = id;
		DataSourceManager.JDBC_PW = pw;
		init();
	}
	
	private void init() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
	}
	
	public static Connection getConnection() throws SQLException {
		Connection con = makeConnection();
		if(con == null) {
			throw new RuntimeException("ConnNotAcailExceiption");
		}
		return con;
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con)
			throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	public static void close(PreparedStatement pstmt, Connection con) 
			throws SQLException {
		close(null, pstmt, con);
	}
	
	public static void close(Connection con) throws SQLException{
		close(null, null, con);
	}
	private static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_ID, JDBC_PW);
	}
}
