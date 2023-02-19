package com.kudangtang.jv300.mod011.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kudangtang.jv300.mod011.domain.User;

public class UserDao {
	
	public void addUser(User user) {
		String sql = "INSERT INTO ModUser(userId, passwd, userName, birthDate, email) VALUE(?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getUserPw());
				pstmt.setString(3, user.getUserName());
				pstmt.setDate(4, new Date(user.getUserBirthDay().getTime()));
				pstmt.setString(5, user.getUserEmail());
				pstmt.executeUpdate();
			}
			finally {
				DataSourceManager.close(pstmt, con);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<User> findUserList(){
		List<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM ModUser ORDER BY id";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setId(rs.getLong("id"));
					user.setUserId(rs.getString("userId"));
					user.setUserPw(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setUserBirthDay(rs.getDate("birthDate"));
					user.setUserEmail(rs.getString("email"));
					user.setRegDate(rs.getString("regDate"));
					userList.add(user);
				}
			}
			finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	public User findUser(String userId, String passwd) {
		String sql = "SELECT * FROM ModUser WHERE userId = ? AND passwd = ?";
		User user = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, passwd);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					user = new User();
					user.setId(rs.getLong("id"));
					user.setUserId(rs.getString("userId"));
					user.setUserPw(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setUserBirthDay(rs.getDate("birthDate"));
					user.setUserEmail(rs.getString("email"));
					user.setRegDate(rs.getString("regDate"));
				}
			}
			finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public void updateUser(User user) {
		String sql = "UPDATE ModUser set passwd = ?, username = ?, email = ? WHERE id = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserPw());
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getUserEmail());
				pstmt.setLong(4, user.getId());
				pstmt.executeUpdate();
			}
			finally {
				DataSourceManager.close(pstmt, con);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
