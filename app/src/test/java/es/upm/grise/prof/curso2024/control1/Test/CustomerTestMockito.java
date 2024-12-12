package es.upm.grise.prof.curso2024.control1.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import es.upm.grise.prof.curso2024.control1.Account;
import es.upm.grise.prof.curso2024.control1.NoAccountsException;
import es.upm.grise.prof.curso2024.control1.Transaction;
import org.junit.jupiter.api.Test;
import es.upm.grise.prof.curso2024.control1.Customer;

public class CustomerTestMockito {
    @Test
    public void testGetCurrentBalanceWithMockito() {

        final float INITIAL_AMOUNT = 100.0f;
        final float TRANSACTION_AMOUNT_1 = 50.0f;
        final float TRANSACTION_AMOUNT_2 = -20.0f;
        final float EXPECTED_BALANCE = 130.0f;

        Account account = new Account();
        account.setInitialAmount(INITIAL_AMOUNT);

        Transaction mockTransaction1 = mock(Transaction.class);
        Transaction mockTransaction2 = mock(Transaction.class);

        when(mockTransaction1.getAmount()).thenReturn(TRANSACTION_AMOUNT_1);
        when(mockTransaction2.getAmount()).thenReturn(TRANSACTION_AMOUNT_2);

        account.addTransaction(mockTransaction1);
        account.addTransaction(mockTransaction2);

        assertEquals(EXPECTED_BALANCE, account.getCurrentBalance());
    }

    @Test
    public void testGetAccountWithHighestBalanceWithMockito() throws NoAccountsException {
        final float FIRST_ACCOUNT_BALANCE = 100.0f;
        final float SECOND_ACCOUNT_BALANCE = 200.0f;
        final float THIRD_ACCOUNT_BALANCE = 50.0f;

        final String ACCOUNT_NUMBER_1 = "12345";
        final String ACCOUNT_NUMBER_2 = "67890";
        final String ACCOUNT_NUMBER_3 = "11223";

        Customer customer = new Customer();

        Account mockAccount1 = mock(Account.class);
        Account mockAccount2 = mock(Account.class);
        Account mockAccount3 = mock(Account.class);

        when(mockAccount1.getCurrentBalance()).thenReturn(FIRST_ACCOUNT_BALANCE);
        when(mockAccount1.getAccountNumber()).thenReturn(ACCOUNT_NUMBER_1);

        when(mockAccount2.getCurrentBalance()).thenReturn(SECOND_ACCOUNT_BALANCE);
        when(mockAccount2.getAccountNumber()).thenReturn(ACCOUNT_NUMBER_2);

        when(mockAccount3.getCurrentBalance()).thenReturn(THIRD_ACCOUNT_BALANCE);
        when(mockAccount3.getAccountNumber()).thenReturn(ACCOUNT_NUMBER_3);

        customer.addAccount(mockAccount1);
        customer.addAccount(mockAccount2);
        customer.addAccount(mockAccount3);

        String highestAccount = customer.getAccountWithHighestBalance();

        assertEquals(ACCOUNT_NUMBER_2, highestAccount);
    }
}

