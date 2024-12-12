package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

	@Test
	public void testGetAccountException(){
		Customer c = new Customer();
		assertThrows(NoAccountsException.class, () -> c.getAccountWithHighestBalance());
		//assertEquals(exception.getMessage(), exception.getMessage());
	}	

	@Test
	public void testGetAccount(){
		Customer c = new Customer();
		Account a = new Account();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a);
		c.setAccounts(accounts);
		try {
			assertEquals(a,c.getAccountWithHighestBalance());
		} catch (NoAccountsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
