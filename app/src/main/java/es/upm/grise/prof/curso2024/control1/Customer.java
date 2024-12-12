package es.upm.grise.prof.curso2024.control1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private List<Account> accounts;
	
	public Customer() {
		accounts = new ArrayList<Account>();
	}

	public String getAccountWithHighestBalance() throws NoAccountsException {
		if (accounts.isEmpty())
			throw new NoAccountsException();

		String selectedAccount = "";
		float maxBalance = Float.MIN_VALUE;
		for (Account account : accounts) {
			if (account.getCurrentBalance() > maxBalance) {
				selectedAccount = account.getAccountNumber();
				maxBalance = account.getCurrentBalance();
			}
		}

		return selectedAccount;
	}


	public void addAccount(Account account) {
		accounts.add(account);
	}
}
