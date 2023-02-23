package vo;

import java.util.ArrayList;

public class User {
	private long uid;
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String email;
	private String phone;
	private String regDate;
	private ArrayList<Account> accountList = new ArrayList<>();

	public User() {
		
	}
	
	public User(String userId, String passwd, String name, String ssn, String email, String phone) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.email = email;
	}
	
	public User(String name, String ssn, String phone) {
		this(name, ssn, phone, null, null, null);
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	
	public void addAccount(Account account) {
		boolean duplicated = false;
		for (Account act : accountList) {
			if (act.getAccountNum().equals(account.getAccountNum())) {
				duplicated = true; // 중복이 되면 true for문을 빠져나간다
				break;
			}
		}
		if (!duplicated) {
			accountList.add(account); // 중복이 아니면 계좌를 추가한다
		}
	}
}
