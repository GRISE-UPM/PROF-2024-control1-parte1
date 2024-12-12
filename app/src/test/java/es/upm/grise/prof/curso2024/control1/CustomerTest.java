package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CustomerTest {

    private Customer cliente;

    @BeforeEach
    void setUp(){
        // Se crea un cliente sin account
        cliente = new Customer();
    }
    @Test
    public void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        assertThrows(NoAccountsException.class, cliente::getAccountWithHighestBalance);
    }

    @Test
    void testGetAccountWithHighestBalanceReturnsCorrectAccountNumber() throws NoAccountsException {
        // creamos el accoun 1
        Account account1 = new Account();
        String numAccount1 = "12345";
        float saldoAccount1 = 100.0f;
        account1.setAccountNumber(numAccount1);
        account1.setInitialAmount(saldoAccount1);

        // creamos el accoun 2
        Account account2 = new Account();
        String numAccount2 = "09876";
        float saldoAccount2 = 300.0f;
        account1.setAccountNumber(numAccount2);
        account1.setInitialAmount(saldoAccount2);

        cliente.addAccount(account1);
        cliente.addAccount(account2);

        //testeamos:
        String numCuentaExpected = "09876";
        String highestBalanceAccountNumber = cliente.getAccountWithHighestBalance();
        assertEquals(numCuentaExpected, highestBalanceAccountNumber);
    }

    // TEST CON MOCKITO
    @Test
    public void testGetAccountWithHighestBalanceReturnsCorrectAccountNumberUsingMockito() throws NoAccountsException {
        // Arrange
        Customer customer = new Customer();

        // Creamos mocks para las cuentas
        Account mockAccount1 = mock(Account.class);
        Account mockAccount2 = mock(Account.class);

        // Configuramos los mocks
        String mockNumAccount1 = "9999";
        float mockSaldoAccount1 = 100.0f;
        when(mockAccount1.getAccountNumber()).thenReturn(mockNumAccount1);
        when(mockAccount1.getCurrentBalance()).thenReturn(mockSaldoAccount1); // Saldo de la primera cuenta

        String mockNumAccount2 = "7878";
        float mockSaldoAccount2 = 600.0f;
        when(mockAccount2.getAccountNumber()).thenReturn(mockNumAccount2);
        when(mockAccount2.getCurrentBalance()).thenReturn(mockSaldoAccount2); // Saldo de la segunda cuenta

        // Agregar las cuentas al cliente
        customer.addAccount(mockAccount1);
        customer.addAccount(mockAccount2);

        // Testeamos
        String numCuentaExpected = "7878";
        String accountWithHighestBalance = customer.getAccountWithHighestBalance();
        assertEquals(numCuentaExpected, accountWithHighestBalance);
    }
}
