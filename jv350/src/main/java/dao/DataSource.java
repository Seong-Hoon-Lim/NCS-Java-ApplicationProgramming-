package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv350?serverTimeoutzone=Asia/Seoul";
	private static final String JDBC_USER = "jv350";
	private static final String JDBC_PASSWD = "jv350" ;
	
	static {
		try {
			Class.forName(JDBC_DRIVER);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
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
	@SuppressWarnings("unused")
	private static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
	}
}
