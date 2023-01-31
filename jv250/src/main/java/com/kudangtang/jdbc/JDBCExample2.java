package com.kudangtang.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC 구성 단계
 * 1. 드라이버 구성 및 로딩하기(로딩은 한번만 실행)
 * 2. 커넥션 가져오기
 * 3. 준비한 쿼리를 처리 할 객체를 생성
 * 4. 실행된 결과를 처리하기
 * 5. 자원 해제하기
 * 
 * @author "SeongHoon"
 *
 */

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
