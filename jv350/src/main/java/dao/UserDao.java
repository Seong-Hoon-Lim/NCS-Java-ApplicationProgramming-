package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.User;

public class UserDao {
	private DataSource dataSource;
	
	public UserDao() {
	}
	
	public UserDao(DataSource data) {
		this.dataSource = data;
	}
	
	public void addUser(User user) {
		String sql = "INSERT INTO User(userId, passwd, name, ssn, email, phone) VALUE(?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getSsn());
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getPhone());

				pstmt.executeUpdate();
			} finally {
				DataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User findUser(String userId, String passwd) {
		String sql = "SELECT * FROM User WHERE userId=? AND passwd=?";
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
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setName(rs.getString("name"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRegDate(rs.getString("regDate"));
				}
			} finally {
				DataSource.close(rs, pstmt, con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public ArrayList<User> findUserList() {
		ArrayList<User> userList = new ArrayList<>();
		String sql = "SELECT * FROM User";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					User user = new User();
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setName(rs.getString("Name"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRegDate(rs.getString("regDate"));
					userList.add(user);
				}
			} finally {
				DataSource.close(rs, pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public User findUserbyId(String id) {
		String sql = "SELECT * FROM User WHERE userId=?";
		User user = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					user = new User();
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setName(rs.getString("name"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setPhone(rs.getString("phone"));
					user.setRegDate(rs.getString("regDate"));
				}
				
			} finally {
				dataSource.close(rs, pstmt, con);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
}
