package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions.assertThrows;

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
		assertEquals(a,c.getAccountWithHighestBalance())

	}
	
}
