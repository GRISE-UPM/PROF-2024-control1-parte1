import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Customer;
import org.example.NoAccountsException;
import org.example.Account;

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

    
}
