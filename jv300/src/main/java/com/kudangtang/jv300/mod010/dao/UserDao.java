package com.kudangtang.jv300.mod010.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.kudangtang.jv300.mod010.domain.User;

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
			pstmt.setDate(4, new Date(user.getBirthDate().getTime));
			pstmt.setString(5, user.getEmail());
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
