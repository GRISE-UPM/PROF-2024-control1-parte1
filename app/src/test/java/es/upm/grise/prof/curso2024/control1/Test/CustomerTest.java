package es.upm.grise.prof.curso2024.control1.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import es.upm.grise.prof.curso2024.control1.*;

public class CustomerTest {

    // Constantes para evitar el code smell
    private static final float FIRST_ACCOUNT_BALANCE = 100.0f;
    private static final float SECOND_ACCOUNT_BALANCE = 200.0f;
    private static final float THIRD_ACCOUNT_BALANCE = 50.0f;

    private static final String ACCOUNT_NUMBER_1 = "123";
    private static final String ACCOUNT_NUMBER_2 = "456";
    private static final String ACCOUNT_NUMBER_3 = "789";

    @Test
    public void testGetAccountWithHighestBalanceException() {
        Customer customer = new Customer();
        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }

    @Test
    public void testGetAccountWithHighestBalance() throws NoAccountsException {

        Account firstAccount = new Account();
        firstAccount.setAccountNumber(ACCOUNT_NUMBER_1);
        firstAccount.setInitialAmount(FIRST_ACCOUNT_BALANCE);

        Account secondAccount = new Account();
        secondAccount.setAccountNumber(ACCOUNT_NUMBER_2);
        secondAccount.setInitialAmount(SECOND_ACCOUNT_BALANCE);

        Account thirdAccount = new Account();
        thirdAccount.setAccountNumber(ACCOUNT_NUMBER_3);
        thirdAccount.setInitialAmount(THIRD_ACCOUNT_BALANCE);

        Customer customer = new Customer();
        customer.addAccount(firstAccount);
        customer.addAccount(secondAccount);
        customer.addAccount(thirdAccount);

        String highestBalance = customer.getAccountWithHighestBalance();

        assertEquals(ACCOUNT_NUMBER_2, highestBalance);
    }
}