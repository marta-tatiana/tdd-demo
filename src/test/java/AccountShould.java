import org.junit.Test;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AccountShould {

    @Test public void reportNoTransactionsWhenCreated() {
        Account account = new Account();
        String report = account.getReport();
        assertThat(report, equalTo("DATE | AMOUNT | BALANCE\n"));
    }

    @Test public void printNoTransactionWhenCreated() {
        PrintStream printStream = mock(PrintStream.class);
        Account account = new Account();
        account.print(printStream);
        verify(printStream, times(1)).print("DATE | AMOUNT | BALANCE\n");
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
