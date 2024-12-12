package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions.*;
public class CustomerTest {
    private Customer customer;
    private Customer customer2;
    private Account account1;
    private Account account2;
    private Account account3;
    @Test
    public void getAccountWithHighestBalanceExceptionTest() throws NoAccountsException{
        customer=new Customer();
        assertThrows(NoAccountsException.class,()->customer.getAccountWithHighestBalance());
    }
    @Test
    void testGetAccountWithHighestBalance() throws NoAccountsException {
        customer2=new Customer();
        account1 = new Account();
        account2 = new Account();
        account3 = new Account();
        List<Account> accounts = List.of(account1, account2, account3);
        customer2.setAccounts(accounts);
        account1.setAccountNumber("1");
        account2.setAccountNumber("2");
        account3.setAccountNumber("3");
        account1.setInitialAmount(100.0f);
        account2.setInitialAmount(1000.0f);
        account3.setInitialAmount(10000.0f);
        String highestBalanceAccount = customer2.getAccountWithHighestBalance();
        assertEquals(account3.getAccountNumber(),highestBalanceAccount,"El número de cuenta con mayor balance es: "+highestBalanceAccount);
    }
}
