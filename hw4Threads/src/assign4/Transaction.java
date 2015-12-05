package assign4;

import java.math.BigDecimal;

public class Transaction {
	private final int from;
	private final int to;
	private final BigDecimal amount;
	
	
	public Transaction(int from, int to, BigDecimal amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}


	public int getFrom() {
		return from;
	}


	public int getTo() {
		return to;
	}


	public BigDecimal getAmount() {
		return amount;
	}
	
	

}
