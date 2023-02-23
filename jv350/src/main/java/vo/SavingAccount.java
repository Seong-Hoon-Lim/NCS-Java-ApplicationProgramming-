package vo;

public class SavingAccount extends Account{
	private double interestRate;
	
	public SavingAccount() {
		
	}
	
	public SavingAccount(String accountNum, double balance, double rate) {
		super(accountNum, balance);
		this.interestRate = rate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
}
