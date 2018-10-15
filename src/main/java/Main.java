
import Data.CSV_Data;
import TransactionSet.TS271;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String ediFileLocationPC = System.getenv("GET_FILE") + "test_file.csv";
    private static final String ediFileLocationMac = System.getenv("LOCATION2") + "test_file.csv";

    public static void main(String[] args) throws Exception {
        TS271 transactionSet = new TS271();
        List<CSV_Data> CSVDataList = new CsvToBeanBuilder<CSV_Data>(new FileReader(ediFileLocationPC))
                .withType(CSV_Data.class).build().parse();
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("EDI_FILE.txt"), "utf-8"));

            // Begin Transaction Set -- ISA and GS info
            writer.write(transactionSet.getISA());
            writer.write(transactionSet.getGS());

            int loopCounter = 0;
            for (CSV_Data d : CSVDataList) {
                loopCounter++;

                // set 1st inner TS
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyymmdd");
                transactionSet.setST("ST*270*00000" + loopCounter + "*005010X279A1~");
                transactionSet.setBHT("BHT*0022*13**"+ dateFormat.format(date) + "*1432~");
                transactionSet.setTRN("TRN*1*00000" + loopCounter + "*94608     ~");
                transactionSet.setREF("REF*SY*" + d.getPatientSSN() + "~");
                transactionSet.setDMG("DMG*D8*" + d.getDateOfBirth() + "~");
                int NPI = String.valueOf(d.getProvider()).equals("") ? 1750353462 : d.getProvider();
                transactionSet.setNM2("NM1*2B*2*Wayne Memorial Hospital*****XX*" + NPI + "~");

                // confirm Discharge Date goes in DTP segment
                transactionSet.setDTP("DTP*291*RD8*" + d.getAdmissionDate() + "-" + d.getDischargeDate() + "~");
                transactionSet.setSE("SE*14*00000" + loopCounter + "~");

                // Write 1st
                writer.write(transactionSet.getST());
                writer.write(transactionSet.getBHT());
                writer.write(transactionSet.getHL1());
                writer.write(transactionSet.getNM1());
                writer.write(transactionSet.getHL2());
                writer.write(transactionSet.getNM2());
                writer.write(transactionSet.getHL3());
                writer.write(transactionSet.getTRN());
                writer.write(transactionSet.getNM3());
                writer.write(transactionSet.getREF());
                writer.write(transactionSet.getDMG());
                writer.write(transactionSet.getDTP());
                writer.write(transactionSet.getEQ());
                writer.write(transactionSet.getSE());


                loopCounter++;

                // Set 2nd inner TS
                transactionSet.setST("ST*270*00000" + loopCounter + "*005010X279A1~");
                transactionSet.setTRN("TRN*1*00000" + loopCounter + "*94608     ~");
                transactionSet.setDTP("DTP*291*D8*" + d.getDischargeDate() + "~");
                transactionSet.setSE("SE*14*00000" + loopCounter + "~");

                // Write 2nd
                writer.write(transactionSet.getST());
                writer.write(transactionSet.getBHT());
                writer.write(transactionSet.getHL1());
                writer.write(transactionSet.getNM1());
                writer.write(transactionSet.getHL2());
                writer.write(transactionSet.getNM2());
                writer.write(transactionSet.getHL3());
                writer.write(transactionSet.getTRN());
                writer.write(transactionSet.getNM3());
                writer.write(transactionSet.getREF());
                writer.write(transactionSet.getDMG());
                writer.write(transactionSet.getDTP());
                writer.write(transactionSet.getEQ());
                writer.write(transactionSet.getSE());
            }
            // Close GS ISA
            writer.write("GE*0000"+ loopCounter +"*13~");
            writer.write("IEA*1*000001333~");
        } catch (IOException ex) {
            System.err.println("Problem writing to the file filename.txt");
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/* ignore */}
        }
    }
}
