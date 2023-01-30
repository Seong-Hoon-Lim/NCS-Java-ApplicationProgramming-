package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.BankConstants;
import com.kudangtang.banking.domain.Customer;
import com.kudangtang.banking.domain.SavingsAccount;
import com.kudangtang.banking.domain.CheckingAccount;

public class AccountDao {
	private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";	
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/jv250?serverTimeoutzone=Asia/Seoul";	
	private static final String JDBC_USER="jv250";	
	private static final String JDBC_PASSWD="jv250";

	
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
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customerId) VALUES (?, ?, ?, ?, ?, ?)";
//		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				
				if(account instanceof SavingsAccount) {
					SavingsAccount saccount = (SavingsAccount)account;
					pstmt.setDouble(3, saccount.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf(BankConstants.SA));
				}
				else {
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ((CheckingAccount)account).getOverdraft());
					pstmt.setString(5, String.valueOf(BankConstants.CA));
					
				}
				pstmt.setLong(6, account.getCustomer().getCid());
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
		String sql = "SELECT * FROM Account";
		List<Account> list = new ArrayList<>();
		Account account = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {

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
	
	
	//계좌 DB 중에 customer ssn을 선택해서 가져오는 메소드
	public List<Account> findAccountsBySsn(String ssn) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, "
				+ " a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
				+ "WHERE c.ssn = ?";
		
		List<Account> list = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
					
				rs = pstmt.executeQuery();
				if (rs.next()) {
					
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
	
	//계좌 DB 중에 accountNum을 선택해서 가져오는 메소드
	public Account findAccountsByAccountNum(String accountNum) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, "
				+ " a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
				+ "WHERE a.accountNum = ?";
		
		Account account = null;
		Customer customer = new Customer();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;			
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);	
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if (rs.getString("accountType").charAt(0) == BankConstants.SA) {
						account = new SavingsAccount();
						((SavingsAccount)account).setInterestRate(
								rs.getDouble("interestRate"));
					}
					else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraft(
								rs.getDouble("overdraft"));
					}
				}
				account.setAid(rs.getLong("aid"));
				account.setAccountNum(rs.getString("accountNum"));
				account.setBalance(rs.getDouble("balance"));
				account.setCustomer(new Customer(rs.getString("name"),
						rs.getString("ssn"), rs.getString("phone")));
				account.setAccountType(rs.getString("accountType").charAt(0));
			}
			else {
				throw new RuntimeException(accountNum + " is not found.");
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
		String sql = "UPDATE Account SET accountNum=?, balance=?, interestRate=?, overdraft=?" + " WHERE accountNum=?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, account.getBalance());
				pstmt.setString(4, account.getAccountNum());
				
				if (account instanceof SavingsAccount) {
					SavingsAccount saccount = (SavingsAccount)account;
					pstmt.setDouble(2, saccount.getInterestRate());
					pstmt.setDouble(3, 0.0);
				}
				else {
					pstmt.setDouble(2, 0.0);
					pstmt.setDouble(3, ((CheckingAccount)account).getOverdraft());
				}
				
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