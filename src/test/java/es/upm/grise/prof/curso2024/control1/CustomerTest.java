package es.upm.grise.prof.curso2024.control1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testGetAccountWithHighestBalanceUsingMockito() throws NoAccountsException {
        // Arrange
        Customer customer = new Customer();

        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);

        when(account1.getAccountNumber()).thenReturn("12345");
        when(account2.getAccountNumber()).thenReturn("67890");

        // Usar reflexión para modificar los campos privados
        setInitialAmount(account1, 100.0f);
        setInitialAmount(account2, 200.0f);

        // Simulamos que los saldos de las cuentas son 100.0f y 200.0f
        when(account1.getCurrentBalance()).thenReturn(100.0f);
        when(account2.getCurrentBalance()).thenReturn(200.0f);

        // Agregar las cuentas al cliente utilizando reflexión
        addAccountToCustomer(customer, account1);
        addAccountToCustomer(customer, account2);

        // Act
        String result = customer.getAccountWithHighestBalance();

        // Assert
        assertEquals("67890", result, "The account with the highest balance should be returned.");
    }

    // Métodos auxiliares para modificar campos privados mediante reflexión
    private void setInitialAmount(Account account, float amount) {
        try {
            var field = Account.class.getDeclaredField("initialAmount");
            field.setAccessible(true);
            field.set(account, amount);
        } catch (Exception e) {
            fail("Failed to set initial amount via reflection.");
        }
    }

    private void addAccountToCustomer(Customer customer, Account account) {
        try {
            var field = Customer.class.getDeclaredField("accounts");
            field.setAccessible(true);
            @SuppressWarnings("unchecked")
            var accounts = (java.util.List<Account>) field.get(customer);
            accounts.add(account);
        } catch (Exception e) {
            fail("Failed to add account to customer via reflection.");
        }
    }
}
