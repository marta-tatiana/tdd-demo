import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {

    private static String header = "DATE | AMOUNT | BALANCE\n";
    private Date lastDate;
    private float balance;
    private float lastTransaction;

    public String getReport() {
        if (lastDate == null)
            return header;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        return header + format.format(lastDate) + " | " +  decimalFormat.format(lastTransaction) + " | " + decimalFormat.format(balance) + "\n";
    }

    public void deposit(Date date, float i) {
        lastDate = date;
        balance = i;
        lastTransaction = i;
    }
}
