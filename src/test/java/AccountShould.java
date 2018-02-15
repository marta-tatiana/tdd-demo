import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class AccountShould {

    @Test public void reportNoTransactionsWhenCreated() {
        Account account = new Account();
        String report = account.getReport();
        assertThat(report, equalTo("DATE | AMOUNT | BALANCE\n"));
    }

    @Test public void reportSingleTransactionWithCorrectFormattingAndBalance() {
        Account account = new Account();
        Calendar calendar = new GregorianCalendar();
        calendar.clear();
        calendar.set(2012, Calendar.JANUARY, 10);
        account.deposit(calendar.getTime(), 100);
        String report = account.getReport();
        assertThat(report, equalTo("DATE | AMOUNT | BALANCE\n10/01/2012 | 100.00 | 100.00\n"));
    }
}
