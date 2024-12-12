package es.upm.grise.prof.curso2024.control1;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String accountNumber;
	private float initialAmount;
	private List<Transaction> transactions;
	
	Account() {
		setTransactions(new ArrayList<Transaction>());
	}
	
	public float getCurrentBalance() {
		
		float result = initialAmount;
		
		for(Transaction transaction : getTransactions()) {
			result += transaction.getAmount();
		}
		
		return result;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
