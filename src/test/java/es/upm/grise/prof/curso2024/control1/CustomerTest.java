package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    void testEjercicio2() {
        // Arrange
        Customer customer = new Customer();

        // Act & Assert
        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance,
                "Expected getAccountWithHighestBalance() to throw NoAccountsException when no accounts are present");
    }

    @Test
    void testEjercicio3() throws NoAccountsException {
        // Arrange
        Customer customer = new Customer();

        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        // Asignar números de cuenta
        setAccountNumber(account1, "12345");
        setAccountNumber(account2, "67890");
        setAccountNumber(account3, "54321");

        // Establecer saldos iniciales
        setInitialAmount(account1, 100.0f);
        setInitialAmount(account2, 200.0f);
        setInitialAmount(account3, 150.0f);

        // Añadir cuentas al cliente utilizando reflexión
        addAccountToCustomer(customer, account1);
        addAccountToCustomer(customer, account2);
        addAccountToCustomer(customer, account3);

        // Act
        String result = customer.getAccountWithHighestBalance();

        // Assert
        assertEquals("54321", result);
    }

    // Métodos auxiliares para modificar campos privados mediante reflexión
    private void setAccountNumber(Account account, String accountNumber) {
        try {
            var field = Account.class.getDeclaredField("accountNumber");
            field.setAccessible(true);
            field.set(account, accountNumber);
        } catch (Exception e) {
            fail("Failed to set account number via reflection.");
        }
    }

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
