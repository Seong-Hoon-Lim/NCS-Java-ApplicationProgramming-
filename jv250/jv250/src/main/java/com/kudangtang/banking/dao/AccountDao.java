package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.Customer;

public class AccountDao {
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";	
	static final String JDBC_URL="jdbc:mysql://localhost:3306/jv250?serverTimeoutzone=Asia/Seoul";	
	static final String JDBC_USER="jv250";	
	static final String JDBC_PASSWD="jv250";
	
	public static String getJdbcDriver() {
		return JDBC_DRIVER;
	}
	public static String getJdbcUrl() {
		return JDBC_URL;
	}
	public static String getJdbcUser() {
		return JDBC_USER;
	}
	public static String getJdbcPasswd() {
		return JDBC_PASSWD;
	}
	
	//드라이버 로딩은 한번만 일어나야 하므로 생성자 생성 될 때만 실행되도록 하기
	public AccountDao() {
			
		try {	
			Class.forName(JDBC_DRIVER);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//계좌 DB 추가하는 메소드
	public static void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customer) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				pstmt.setDouble(3, account.getInterestRate());
				pstmt.setDouble(4, account.getOverdraft());
				pstmt.setByte(5, (byte) account.getAccountType());
				pstmt.setObject(6, account.getCustomer());	
				pstmt.executeUpdate();
			}
			finally {
				pstmt.close();
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//계좌 DB 리스트를 선택해서 가져오는 메소드
	public List<Account> findAllAccountList() {
		List<Account> list = new ArrayList<>();
		Account account = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				
				String sql = "SELECT * FROM Account";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					account = new Account(rs.getString("accountNum")
							,rs.getDouble("balance"),rs.getDouble("interestRate")
							,rs.getDouble("overdraft"),rs.getByte("accountType")
							,(Customer) rs.getObject("customer"));
					list.add(account);
				}
			}
			finally {
				rs.close();
				pstmt.close();
				con.close();			
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	//계좌 DB 중에 customer을 선택해서 가져오는 메소드
	public Account findAccountByCustomer(Customer customer) {
		Account account = null;
		String sql = "SELECT * FROM Account WHERE customer = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);				
				pstmt = con.prepareStatement(sql);
				pstmt.setObject(1, customer);
					
				rs = pstmt.executeQuery();
				if (rs.next()) {
					account = new Account(rs.getString("accountNum")
							,rs.getDouble("balance"),rs.getDouble("interestRate")
							,rs.getDouble("overdraft"),rs.getByte("accountType")
							,(Customer) rs.getObject("customer"));
				}
			}
			finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
		return account;
	}
		
	//계좌 DB를 수정하는 메소드
	public void updateAccount(Account account) {
		try {
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				String sql = "UPDATE Account SET accountNum=?, balance=?, interestRate=?, overdraft=?, customer=?,  WHERE customer=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				pstmt.setDouble(3, account.getInterestRate());
				pstmt.setDouble(4, account.getOverdraft());
				pstmt.setByte(5, (byte) account.getAccountType());
				pstmt.setObject(6, account.getCustomer());	
				pstmt.setObject(7, account.getCustomer());	
				pstmt.executeUpdate();
			}
			finally {
				pstmt.close();
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	//계좌 DB를 삭제하는 메소드
	public void deleteAccount() {
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				String sql = "DELETE FROM Customer WHERE customer=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setObject(1, account.getCustomer());
				pstmt.executeUpdate();
			
			}
			finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			}
		}
	}