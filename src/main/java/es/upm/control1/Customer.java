package es.upm.control1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private List<Account> accounts;
	
	Customer() {
		accounts = new ArrayList<Account>();
	}

	public void addAccount(Account account){
		accounts.add(account);
	}

	public String getAccountWithHighestBalance() throws NoAccountsException {
		
		if(accounts.isEmpty()) {
			throw new NoAccountsException();
		}
		
		
		String selectedAccount = "";
		float maxBalance = 0;
		
		for(Account account : accounts) {
			
			if(account.getCurrentBalance() > maxBalance) {
				
				selectedAccount = account.getAccountNumber();
				maxBalance = account.getCurrentBalance();
				
			}
			
		}
		
		return selectedAccount;
		
	}
	
}
