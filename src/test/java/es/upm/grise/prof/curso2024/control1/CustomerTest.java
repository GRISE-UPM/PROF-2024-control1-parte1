package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
//atempt 2
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
		a.setTransaction();
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a);
		c.setAccounts(accounts);
		try {
			assertEquals(a.getAccountNumber(),c.getAccountWithHighestBalance());
		} catch (NoAccountsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void mockAccount(){
		Account A = new Account();
		Transaction T = mock(Transaction.class);
		float Tammount=(float)1.0;
		float T2ammount=(float)2.0;
		Transaction T2 = mock(Transaction.class);
		when(T.getAmount()).thenReturn(Tammount);
		when(T2.getAmount()).thenReturn(T2ammount);
		A.setTransaction(T);
		A.setTransaction(T2);
		assertEquals(T2ammount+Tammount, A.getCurrentBalance());
	}

	@Test
	public void mockGetAccount(){
		Customer c = new Customer();
		Account a = mock(Account.class);
		when(a.getCurrentBalance()).thenReturn((float)0.0);
		when(a.getAccountNumber()).thenReturn("").thenReturn("");
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a);
		c.setAccounts(accounts);
		try {
			assertEquals(a.getAccountNumber(),c.getAccountWithHighestBalance());
		} catch (NoAccountsException e) {
			e.printStackTrace();
		}

	}
	
}
