package TransactionSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TS271 {
    private String ISA;


    public void setISA(String ISA) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.ISA = "ISA*00*          *00*          *ZZ*RM1P           *ZZ*NCTRACKSBAT    *" +
                dateFormat.format(date) +



    }
}
