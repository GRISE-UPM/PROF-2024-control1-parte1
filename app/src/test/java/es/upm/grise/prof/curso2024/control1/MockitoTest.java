package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class MockitoTest {
    private static final float INITIAL_BALANCE = 1000.0f;
    private static final float TRANSACTION_1 = 500.0f;
    private static final float TRANSACTION_2 = -200.0f;
    final String ACCOUNT_NUMBER = "12345";
    final String ACCOUNT_2_NUMBER = "67890";
    
    private Account account;
    private Account account2;
    private Transaction transaction1;
    private Transaction transaction2;


    @Test
    //Verifique que el método getCurrentBalance() devuelve correctamente el saldo de la Account.
    public void testGetCurrentBalance(){
        account = new Account();
        account2 = new Account();
        account.setAccount(ACCOUNT_NUMBER, INITIAL_BALANCE);
        account2.setAccount(ACCOUNT_2_NUMBER, INITIAL_BALANCE);
     
        transaction1 = mock(Transaction.class);
        transaction2 = mock(Transaction.class);
        
        // Configurar comportamiento de los mocks
        when(transaction1.getAmount()).thenReturn(TRANSACTION_1); // Transacción de ingreso
        when(transaction2.getAmount()).thenReturn(TRANSACTION_2); // Transacción de retiro

        // Agregar las transacciones a la cuenta
        account.addTransaction(transaction1);
        account.addTransaction(transaction2); // account:  1000 + 500 - 200 = 1300
        account2.addTransaction(transaction1); //account2: 1000 + 500 = 1500
        float expectedBalance = INITIAL_BALANCE + TRANSACTION_1 + TRANSACTION_2; // 1000 + 500 - 200 = 1300
        float actualBalance = account.getCurrentBalance();
        
        assertEquals(expectedBalance, actualBalance, "El saldo actual debe ser correcto.");
    }
/* 
    @Test
    // Verifica que el método getAccountWithHighestBalance() devuelve correctamente el accountNumber que corresponde con la Account que posee el mayor saldo.
    public void testGetAccountWithHighestBalanceCorrectAccountMockito() throws NoAccountsException {
        Account mockAccount1 = mock(Account.class);
        Account mockAccount2 = mock(Account.class);

        when(mockAccount1.getCurrentBalance()).thenReturn(1300.0f); // Cuenta 1 con saldo 1300
        when(mockAccount2.getCurrentBalance()).thenReturn(1500.0f); // Cuenta 2 con saldo 1500
        when(mockAccount1.getAccountNumber()).thenReturn(ACCOUNT_NUMBER);
        when(mockAccount2.getAccountNumber()).thenReturn(ACCOUNT_2_NUMBER);

        List<Account> mockAccounts = new ArrayList<>();
        mockAccounts.add(mockAccount1);
        mockAccounts.add(mockAccount2);

        Customer customer = mock(Customer.class);
        when(customer.getAccounts()).thenReturn(mockAccounts);

        String result = customer.getAccountWithHighestBalance();
        String expectedResult = ACCOUNT_2_NUMBER;

        assertEquals(expectedResult, result, "El método no devolvió el número de cuenta con el saldo más alto.");
    }
        */
}
