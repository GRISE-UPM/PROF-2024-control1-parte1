package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Mockito:
import org.mockito.Mockito;
import static org.mockito.Mockito.*;


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
}
