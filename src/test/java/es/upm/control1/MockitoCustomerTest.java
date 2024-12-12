package es.upm.control1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockitoCustomerTest {

    //Verifique que el método getCurrentBalance() devuelve correctamente el saldo de la Account.
    @Test
    void testAccountBalance() {
        final float INITIAL_AMOUNT = 1000;
        final float TRANSACTION_AMOUNT_1 = 200;
        final float TRANSACTION_AMOUNT_2 = -150;
        final float EXPECTED_BALANCE = 1050;

        Account account = new Account();
        // No puedo hacerle mock a account
        account.setInitialAmount(INITIAL_AMOUNT);

        Transaction transaction1 = mock(Transaction.class);
        when(transaction1.getAmount()).thenReturn(TRANSACTION_AMOUNT_1);

        Transaction transaction2 = mock(Transaction.class);
        when(transaction2.getAmount()).thenReturn(TRANSACTION_AMOUNT_2);

        account.addTransaction(transaction1);
        account.addTransaction(transaction2);

        float currentBalance = account.getCurrentBalance();

        // Verificar el saldo calculado
        assertEquals(EXPECTED_BALANCE, currentBalance,0.01);
    }

    @Test
    void testGetAccountWithHighestBalance() throws NoAccountsException {
        final String HIGH_ACCOUNT = "n1";
        final float HIGH_BALANCE = 5000;
        final String LOW_ACCOUNT = "n2";
        final float LOW_BALANCE = 1500;

        // Mockear cuentas
        Account highBalanceAccount = mock(Account.class);
        when(highBalanceAccount.getAccountNumber()).thenReturn(HIGH_ACCOUNT);
        when(highBalanceAccount.getCurrentBalance()).thenReturn(HIGH_BALANCE);

        Account lowBalanceAccount = mock(Account.class);
        when(lowBalanceAccount.getAccountNumber()).thenReturn(LOW_ACCOUNT);
        when(lowBalanceAccount.getCurrentBalance()).thenReturn(LOW_BALANCE);

        Customer customer = new Customer();
        customer.addAccount(highBalanceAccount);
        customer.addAccount(lowBalanceAccount);

        String result = customer.getAccountWithHighestBalance();
        assertEquals(HIGH_ACCOUNT, result);
    }
}
