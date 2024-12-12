import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountTest {
 
    @Test
    void getCurrentBalance_ShouldReturnCorrectBalance() {
        Account account = new Account();
        account.setInitialAmount(100.0f);
        Transaction transaction1 = mock(Transaction.class);
        Transaction transaction2 = mock(Transaction.class);
        when(transaction1.getAmount()).thenReturn(50.0f);
        when(transaction2.getAmount()).thenReturn(-20.0f);
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);
        assertEquals(130.0f, account.getCurrentBalance());
    }
}
