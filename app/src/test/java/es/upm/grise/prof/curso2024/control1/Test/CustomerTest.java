package es.upm.grise.prof.curso2024.control1.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import es.upm.grise.prof.curso2024.control1.*;

public class CustomerTest {

    private static final float FIRST_ACCOUNT_BALANCE = 100.0f;
    private static final float SECOND_ACCOUNT_BALANCE = 200.0f;
    private static final float THIRD_ACCOUNT_BALANCE = 50.0f;


    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }

    @Test
    public void testGetAccountWithHighestBalance() throws NoAccountsException {

        Account firstAccount = new Account();
        firstAccount.setAccountNumber("12345");
        firstAccount.setInitialAmount(FIRST_ACCOUNT_BALANCE);

        Account secondAccount = new Account();
        secondAccount.setAccountNumber("67890");
        secondAccount.setInitialAmount(SECOND_ACCOUNT_BALANCE);

        Account thirdAccount = new Account();
        thirdAccount.setAccountNumber("11223");
        thirdAccount.setInitialAmount(THIRD_ACCOUNT_BALANCE);

        Customer customer = new Customer();
        customer.addAccount(firstAccount);
        customer.addAccount(secondAccount);
        customer.addAccount(thirdAccount);

        String accountWithHighestBalance = customer.getAccountWithHighestBalance();

        assertEquals("67890", accountWithHighestBalance);
    }
}