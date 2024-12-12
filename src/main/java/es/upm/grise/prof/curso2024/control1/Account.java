package es.upm.grise.prof.curso2024.control1;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String accountNumber;
	private float initialAmount;
	private List<Transaction> transactions;
	
	Account() {
		transactions = new ArrayList<Transaction>();
	}
	
	public float getCurrentBalance() {
		
		float result = initialAmount;
		
		for(Transaction transaction : transactions) {
			result += transaction.getAmount();
		}
		
		return result;
	}

	void setTransaction(){
		Transaction T =new Transaction();
		T.setAmount((float)1.0);
		transactions.add(T);
	}
	void setTransaction(Transaction T){
		transactions.add(T);
	}

	public void setAccounNumber(String newNum) {
		this.accountNumber=newNum;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

}
