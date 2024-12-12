package es.upm.control1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void testNoAccountsException() {
        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }

    @Test
    void testGetAccountWithHighestBalance() throws NoAccountsException {
        final float HIGHEST_BALANCE = 300;
        final float MID_BALANCE = 200;
        final float LOWEST_BALANCE = 159;

        final String HIGHEST_ACCOUNT = "N1";
        final String MID_ACCOUNT = "N1";
        final String LOWEST_ACCOUNT = "N1";

        Customer customer = new Customer();

        Account highestAccount = new Account();
        Account midAccount = new Account();
        Account lowestAccount = new Account();

        highestAccount.setInitialAmount(HIGHEST_BALANCE);
        midAccount.setInitialAmount(MID_BALANCE);
        lowestAccount.setInitialAmount(LOWEST_BALANCE);

        highestAccount.setAccountNumber(HIGHEST_ACCOUNT);
        midAccount.setAccountNumber(MID_ACCOUNT);
        lowestAccount.setAccountNumber(LOWEST_ACCOUNT);

        customer.addCustomer(highestAccount);
        customer.addCustomer(midAccount);
        customer.addCustomer(lowestAccount);

        Assertions.assertEquals(
                HIGHEST_ACCOUNT,
                customer.getAccountWithHighestBalance()
        );

    }

}
