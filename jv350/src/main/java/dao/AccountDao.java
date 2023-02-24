package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Account;
@SuppressWarnings("unused")
public class AccountDao {
	
	private DataSource dataSource;
	private Account Acc;
	
	public AccountDao() {
		
	}
	
	public AccountDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, overdraft, accountType, userId) VALUE(?, ?, ?, ?, ?, ?)";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				pstmt.setDouble(3, account.getInterestRate());
				pstmt.setDouble(4, account.getOverdraft());
				pstmt.setString(5, String.valueOf(account.getAccountType()));
				pstmt.setString(6, account.getUserId());
				pstmt.executeUpdate();
			} finally {
				DataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void withdraw(Account account, double amount) {
		String sql = "UPDATE Account SET balance = ? WHERE AccountNum = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, (account.getBalance() - amount));
				pstmt.setString(2, account.getAccountNum());
				pstmt.executeUpdate();
			} finally {
				DataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deposit(Account account) {
		String sql = "UPDATE Account SET balance = ? WHERE AccountNum = ? ";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, account.getBalance());
				pstmt.setString(2, account.getAccountNum());
				pstmt.executeUpdate();
			} finally {
				DataSource.close(pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Account> findAllAccounts() {
		ArrayList<Account> accAllList = new ArrayList<>();
		Account account = null;
		String sql = "SELECT * FROM Account";
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
					account.setAccountType((rs.getString("accountType")).charAt(0));
					account.setUserId("userId");
					accAllList.add(account);
				}
			}
				finally {
					DataSource.close(rs, pstmt, con);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		return accAllList;			
	}
	
	public ArrayList<Account> findAccountByUserId(String userId) {
		ArrayList<Account> accountList = new ArrayList<>();
		String sql = "SELECT * FROM Account WHERE userId=?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					account = new Account();
					account.setUserId(rs.getString("userId"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType((rs.getString("accountType")).charAt(0));
					account.setAccountNum(rs.getString("accountNum"));
					accountList.add(account);
				}
				
			} finally {
				DataSource.close(rs, pstmt, con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}	
	
	public ArrayList<Account> findAccountByAccountNum(String accountNum) {
		ArrayList<Account> list = new ArrayList<>();
		String sql = "SELECT * FROM Account WHERE accountNum=?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					account = new Account();
					account.setUserId(rs.getString("userId"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType((rs.getString("accountType")).charAt(0));
					account.setAccountNum(rs.getString("accountNum"));				
					list.add(account);
				}
			}
			finally {
				DataSource.close(rs, pstmt, con);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 	DB에서 특정 ID에 해당하는 전체 계좌를 삭제
	 */
	public void deleteAccountByUserId(String userId) {
		String sql = "DELETE FROM Account WHERE userId=?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				int idx = 1;
				pstmt.setString(idx++, userId);
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
	 * 	DB에서 특정 ID에 해당하는 특정 계좌를 삭제
	 */
	public void deleteAccountByAccNum(String userId, String accountNum) {
		String sql = "DELETE FROM Account WHERE userId=?";
		Account account = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;		
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				int idx = 1;
				pstmt.setString(idx++, userId);
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
	
}
