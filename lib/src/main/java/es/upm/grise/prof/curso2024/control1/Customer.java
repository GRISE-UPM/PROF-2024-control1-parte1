package es.upm.grise.prof.curso2024.control1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private List<Account> accounts;
	
	Customer() {
		setAccounts(new ArrayList<Account>());
	}
	
	public String getAccountWithHighestBalance() throws NoAccountsException {
		
		if(getAccounts().isEmpty()) {
			throw new NoAccountsException();
		}
		
		
		String selectedAccount = "";
		float maxBalance = 0;
		
		for(Account account : getAccounts()) {
			
			if(account.getCurrentBalance() > maxBalance) {
				
				selectedAccount = account.getAccountNumber();
				
			}
			
		}
		
		return selectedAccount;
		
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
