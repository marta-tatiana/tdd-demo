import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AccountShould {

    @Test public void reportNoTransactionsWhenCreated() {
        Account account = new Account();
        String report = account.getReport();
        assertThat(report, equalTo("DATE | AMOUNT | BALANCE\n"));
    }
}
