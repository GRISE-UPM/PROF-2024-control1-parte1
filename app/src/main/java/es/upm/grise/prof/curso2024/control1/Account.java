package es.upm.grise.prof.curso2024.control1;

import java.util.ArrayList;
import java.util.List;
//Commit prueba
public class Account {
	
	private String accountNumber;
	private float initialAmount;
	private List<Transaction> transactions;
	
	public Account() {
	    transactions = new ArrayList<>();
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