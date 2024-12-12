package es.upm.grise.prof.curso2024.control1;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String accountNumber;
	private float initialAmount;
	private final List<Transaction> transactions;
	
	public Account() {
		transactions = new ArrayList<Transaction>();
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

	public void setAccountNumber(String number) {
		accountNumber = number;
	}

	public void setInitialAmount(float amount) {
		initialAmount = amount;
	}

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
}
