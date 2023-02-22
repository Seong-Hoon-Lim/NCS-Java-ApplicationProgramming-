package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Account;
import com.kudangtang.banking.domain.BankConstants;
import com.kudangtang.banking.domain.CheckingAccount;
import com.kudangtang.banking.domain.SavingsAccount;

public class AccountDao {
	private DataSource dataSource;
	
	public AccountDao() {
		
	}
	
	public AccountDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * DB에 계좌를 등록
	 * @param account
	 */
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, customerId)"
						+ "VALUES(?,?,?,?,?,?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				
				if (account instanceof SavingsAccount) {
					pstmt.setDouble(3, ((SavingsAccount)account).getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf(BankConstants.SA));
				}
				else {
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ((CheckingAccount)account).getOverdraft());
					pstmt.setString(5, String.valueOf(BankConstants.CA));
				}
				pstmt.setLong(6, account.getCustomer().getId());
				pstmt.executeUpdate();
			}
			finally {
				DataSource.close(pstmt, con);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * DB에 등록된 모든 계좌 리스트 조회
	 * @return
	 */
	public List<Account> findAllAccountList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Account";
		List<Account> list = new ArrayList<>();
		Account account = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					account = new Account();
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setInterestRate(rs.getDouble("interestRate"));
					account.setOverdraft(rs.getDouble("overdraft"));
					account.setAccountType((char) rs.getByte(("accountType")));
					account.setAid(rs.getLong("aid"));
					account.setAid(rs.getLong("aid"));
					account.setAid(rs.getLong("aid"));
					list.add(account);
				}
			}
			finally {
				DataSource.close(rs, pstmt, con);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * DB에 등록된 계좌 중 특정 계좌 조회
	 * @param accountNum
	 * @return
	 */
	public Account findAccountsByAccountNum(String accountNum) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 계좌 이체(입금,출금) 잔액 변동
	 * @param balance
	 */
	public void updateBalance(double balance) {
		
	}

}
