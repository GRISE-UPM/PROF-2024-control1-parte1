import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CustomerTest {

    @Test
    void getAccountWithHighestBalance_ShouldThrowException_WhenNoAccounts() {
        Customer customer = new Customer();
        Exception exception = assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
        //se espera null porque el mensaje de la excepción es null
        assertEquals(null, exception.getMessage());
    }

    @Test
    void getAccountWithHighestBalance_ShouldReturnAccountWithMaxBalance_WhenAccountsArePresent() {
        Customer customer = new Customer();
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        //he añadido seters para poder asignar el número de cuenta y el saldo inicial
        account1.setAccountNumber("123");
        account2.setAccountNumber("456");
        account3.setAccountNumber("789");
        
        account2.setInitialAmount(200.0f);
        account3.setInitialAmount(300.0f);

        //tambien he añadido addCount para añadir cuentas a un cliente
        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        String result;
        try {
            result = customer.getAccountWithHighestBalance();
        } catch (NoAccountsException e) {
            fail("NoAccountsException was thrown unexpectedly");
            return;
        }
        assertEquals("789", result);
    }

    @Test
    void getAccountWithHighestBalance_ShouldReturnCorrectAccountNumber() throws NoAccountsException {
        Customer customer = new Customer();
        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);
        Account account3 = mock(Account.class);

        when(null).thenReturn("123");
        when(account2.getAccountNumber()).thenReturn("456");
        when(account3.getAccountNumber()).thenReturn("789");

        when(account1.getInitialAmount()).thenReturn(100.0f);
        when(account2.getInitialAmount()).thenReturn(200.0f);
        when(account3.getInitialAmount()).thenReturn(300.0f);
        String result = customer.getAccountWithHighestBalance();
        assertEquals("67890", result); 

        }


    
}
