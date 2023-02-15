package com.kudangtang.jv300.mod010.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
	
	private final String jdbcDriver;
	private final String jdbcURL;	
	private final String userName;	
	private final String password;
	
	public DataSource(String driver, String url, 
						String userName, String password) 
								throws ClassNotFoundException, SQLException {
		super();
		this.jdbcDriver = driver;
		this.jdbcURL = url;
		this.userName = userName;
		this.password = password;
		
		init();
	}
			
	/**
	 * 생성된 커넥션을 가져오는 메소드
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcURL, userName, password);
		
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
	
	/**
	 * 클래스 로딩 메소드
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	private void init() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcDriver);
	}
	
	/**
	 * 커넥션 생성 메소드
	 * @return
	 * @throws SQLException
	 */
	private Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(jdbcURL, userName, password);
	}
	
	/**
	 * jdbcDriver 를 가져오는 메소드
	 * @return
	 */
	public String getJdbcDriver() {
		return jdbcDriver;
	}

}
