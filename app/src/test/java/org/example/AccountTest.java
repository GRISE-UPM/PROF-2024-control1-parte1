package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class AccountTest {

    //Verifique que el mét  odo getCurrentBalance() devuelve correctamente el saldo de la Account con mocking
     @Test
    void testGetCurrentBalance() {
       
        Account mockAccount = mock(Account.class);

        when(mockAccount.getCurrentBalance()).thenReturn(100.0f);

        // Verificar que el saldo retornado sea el esperado
        assertEquals(100.0f, mockAccount.getCurrentBalance());
        
     
        verify(mockAccount).getCurrentBalance();
    }

    //test como ej 3 pero con mocking
    
    @Test
    public void testGetAccountWithHighestBalance() throws NoAccountsException {
        // Crear el mock de Customer y Account
        Customer customer = mock(Customer.class);
        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);
        
        // Definir los valores de las transacciones y saldo
        final float TRANSACTION_1 = 100.0f;
        final float TRANSACTION_2 = 200.0f;
        final float TRANSACTION_3 = 300.0f;
        final float TRANSACTION_4 = 400.0f;

        // Configurar el comportamiento de las cuentas mockeadas
        when(account1.getCurrentBalance()).thenReturn(TRANSACTION_1 + TRANSACTION_2); // 300.0f
        when(account2.getCurrentBalance()).thenReturn(TRANSACTION_3 + TRANSACTION_4); // 700.0f
        
        // Simular la adición de las cuentas al cliente
        when(customer.getAccountWithHighestBalance()).thenReturn(account2.getAccountNumber()); 

        // Verificar que el método getAccountWithHighestBalance devuelve el accountNumber correcto
        assertEquals(account2.getAccountNumber(), customer.getAccountWithHighestBalance());

        // Verificar que se invocaron los métodos esperados
        verify(account1).getCurrentBalance();
        verify(account2).getCurrentBalance();
    }
} 
    

