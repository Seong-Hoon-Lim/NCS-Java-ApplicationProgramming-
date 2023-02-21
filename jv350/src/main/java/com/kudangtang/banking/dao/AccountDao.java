package com.kudangtang.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.kudangtang.banking.DataSource;
import com.kudangtang.banking.domain.Account;

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
		String sql = "INSERT TO Account(accountNum, balance, interestRate, overdraft, accountType, customerId)"
						+ "VALUES(?,?,?,?,?,?)";
		try (Connection con = dataSource.getConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql);) {
			 pstmt.setString(1, account.getAccountNum());
			 pstmt.setDouble(2, account.getBalance());
			 pstmt.setDouble(3, account.getInterestRate());
			 pstmt.setDouble(4, account.getOverdraft());
			 pstmt.setByte(5, (byte)account.getAccountType());
			 pstmt.setLong(6, account.getCustomerId());
			
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
		return null;
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
