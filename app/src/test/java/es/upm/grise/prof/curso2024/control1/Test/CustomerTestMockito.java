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
    public void testGetCurrentBalanceMockito() {
        // Constantes para evitar el code smell
        final float INITIAL_AMOUNT = 100.0f;
        final float TRANSACTION_1 = 50.0f;
        final float TRANSACTION_2 = -20.0f;
        final float FINAL_BALANCE = 130.0f;

        Account account = new Account();
        account.setInitialAmount(INITIAL_AMOUNT);

        Transaction mockTransaction1 = mock(Transaction.class);
        Transaction mockTransaction2 = mock(Transaction.class);

        // Definimos que haran los mocks
        when(mockTransaction1.getAmount()).thenReturn(TRANSACTION_1);
        when(mockTransaction2.getAmount()).thenReturn(TRANSACTION_2);

        // Anadimos transacciones
        account.addTransaction(mockTransaction1);
        account.addTransaction(mockTransaction2);

        // Probamos
        assertEquals(FINAL_BALANCE, account.getCurrentBalance());
    }

    @Test
    public void testGetAccountWithHighestBalanceMockito() throws NoAccountsException {
        // Constantes para evitar el code smell
        final float FIRST_ACCOUNT = 100.0f;
        final float SECOND_ACCOUNT = 200.0f;
        final float THIRD_ACCOUNT = 50.0f;

        final String ACCOUNT_NUMBER_1 = "123";
        final String ACCOUNT_NUMBER_2 = "456";
        final String ACCOUNT_NUMBER_3 = "789";

        Customer customer = new Customer();

        // Creamos los mocks
        Account mock1 = mock(Account.class);
        Account mock2 = mock(Account.class);
        Account mock3 = mock(Account.class);

        // Definimos que haran los mocks
        when(mock1.getCurrentBalance()).thenReturn(FIRST_ACCOUNT);
        when(mock1.getAccountNumber()).thenReturn(ACCOUNT_NUMBER_1);

        when(mock2.getCurrentBalance()).thenReturn(SECOND_ACCOUNT);
        when(mock2.getAccountNumber()).thenReturn(ACCOUNT_NUMBER_2);

        when(mock3.getCurrentBalance()).thenReturn(THIRD_ACCOUNT);
        when(mock3.getAccountNumber()).thenReturn(ACCOUNT_NUMBER_3);

        // Anadimos las cuentas
        customer.addAccount(mock1);
        customer.addAccount(mock2);
        customer.addAccount(mock3);

        // Ejecutamos
        String highestAccount = customer.getAccountWithHighestBalance();

        // Probamos
        assertEquals(ACCOUNT_NUMBER_2, highestAccount);
    }
}

