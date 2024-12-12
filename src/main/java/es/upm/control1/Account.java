package es.upm.control1;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String accountNumber;
	private float initialAmount;
	private List<Transaction> transactions;
	
	Account() {
		transactions = new ArrayList<Transaction>();
	}

	public void addTransaction(Transaction transaction){
		transactions.add(transaction);
	}

	public void setInitialAmount(float initialAmount) {
		this.initialAmount = initialAmount;
	}

	public void setAccountNumber(String accountNumber){
		this.accountNumber = accountNumber;
	}

	public float getCurrentBalance() {
		
		float result = initialAmount;
		
		for(Transaction transaction : transactions) {
			result += transaction.getAmount();
		}
		
		return result;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

}
