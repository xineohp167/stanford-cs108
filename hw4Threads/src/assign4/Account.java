package assign4;

import java.math.BigDecimal;

public class Account {
	private int id;
	private BigDecimal balance;
	private int numOfTransactions;
	
	
	public Account(int id, BigDecimal balance, int numOfTransactions) {
		this.id = id;
		this.balance = balance;
		this.numOfTransactions = numOfTransactions;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance
				+ ", numOfTransactions=" + numOfTransactions + "]";
	}


	
	public synchronized void withdraw(Transaction tr){
		this.balance.subtract(tr.getAmount());
		this.numOfTransactions++;
	}
	
	public synchronized void deposit(Transaction tr){
		this.balance.add(tr.getAmount());
		this.numOfTransactions++;
	}
}
