package com.kudangtang.jv300.mod011;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;


public class UserDao {			
	private DataSource dataSource;
			
	public UserDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void saveUser(User user) {
		String sql = "INSERT INTO ModUser(userId, passwd, userName, birthDate, email)"
						+ "VALUES(?, ?, ?, ?, ?)";
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setDate(4, new Date(user.getBirthDate().getTime()));
			pstmt.setString(5, user.getEmail());
//			pstmt.setString(6, user.getRegDate());			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User findUser(String userId, String passwd) {
		String sql = "SELECT id, userId, passwd, userName, birthDate, email, regDate "
					+ "FROM ModUser WHERE userId=? AND passwd=?";
		User user = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, passwd);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					user = new User();
					user.setId(rs.getLong("id"));
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setBirthDate(rs.getDate("birthDate"));
					user.setEmail(rs.getString("email"));
//					user.setRegDate(rs.getTimestamp("regDate"));					
				}
					
			}
			finally {
				dataSource.close(rs, pstmt, con);
			}
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		return user;
	}
	
	/**
	 * User 정보를 DB에서 찾는 메소드
	 * @return
	 */
	public List<User> findAllUserList() {		
		List<User> list = new ArrayList<>();
		String sql = "SELECT * FROM ModUser";
		User user = null;		
		try (Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("userId"));
				user.setPasswd(rs.getString("passwd"));
				user.setUserName(rs.getString("userName"));
				user.setBirthDate(rs.getDate("birthDate"));
				user.setEmail(rs.getString("email"));
//				user.setRegDate(rs.getTimestamp("regDate"));
				list.add(user);
			}
		}		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void userInfoModify(User user) {
		String sql = "UPDATE ModUser" + "SET passwd=?"
						+ "WHERE idx=2";
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getUserName());
			pstmt.setDate(4, new Date(user.getBirthDate().getTime()));
			pstmt.setString(5, user.getEmail());
//			pstmt.setString(6, user.getRegDate());			
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
