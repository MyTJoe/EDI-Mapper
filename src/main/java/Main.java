
import Data.CSV_Data;
import TransactionSet.TS271;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final String ediFileLocationPC = System.getenv("LOC_PC") + "test_file.csv";
    private static final String ediFileLocationMac = System.getenv("LOC_MAC") + "test_file.csv";

    public static void main(String[] args) throws Exception {
        TS271 transactionSet = new TS271();
        List<CSV_Data> CSVDataList = new CsvToBeanBuilder<CSV_Data>(new FileReader(ediFileLocationMac))
                .withType(CSV_Data.class).build().parse();
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("EDI_FILE.txt"), "utf-8"));

            // Begin Transaction Set -- ISA and GS info
            writeToFile(writer,transactionSet.getISA());
            writeToFile(writer,transactionSet.getGS());

            int loopCounter = 0;
            for (CSV_Data d : CSVDataList) {
                loopCounter++;

                // set 1st inner TS
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                transactionSet.setST("ST*270*00000" + loopCounter + "*005010X279A1~");
                transactionSet.setBHT("BHT*0022*13**"+ dateFormat.format(date) + "*1432~");
                transactionSet.setTRN("TRN*1*00000" + loopCounter + "*94608     ~");
                transactionSet.setREF("REF*SY*" + d.getPatientSSN() + "~");
                transactionSet.setDMG("DMG*D8*" + d.getDateOfBirth() + "~");
                int NPI = String.valueOf(d.getProvider()).equals("") ? 1750353462 : d.getProvider();
                transactionSet.setNM2("NM1*2B*2*Wayne Memorial Hospital*****XX*" + NPI + "~");

                //TODO confirm Admission and Discharge Date go in 1st DTP segment
                transactionSet.setDTP("DTP*291*RD8*" + d.getAdmissionDate() + "-" + d.getDischargeDate() + "~");
                transactionSet.setSE("SE*14*00000" + loopCounter + "~");

                // Write 1st
                writeToFile(writer, transactionSet.getST());
                writeToFile(writer, transactionSet.getBHT());
                writeToFile(writer, transactionSet.getHL1());
                writeToFile(writer, transactionSet.getNM1());
                writeToFile(writer, transactionSet.getHL2());
                writeToFile(writer, transactionSet.getNM2());
                writeToFile(writer, transactionSet.getHL3());
                writeToFile(writer, transactionSet.getTRN());
                writeToFile(writer, transactionSet.getNM3());
                writeToFile(writer, transactionSet.getREF());
                writeToFile(writer, transactionSet.getDMG());
                writeToFile(writer, transactionSet.getDTP());
                writeToFile(writer, transactionSet.getEQ());
                writeToFile(writer, transactionSet.getSE());

                // Set 2nd inner TS
                loopCounter++;
                transactionSet.setST("ST*270*00000" + loopCounter + "*005010X279A1~");
                transactionSet.setTRN("TRN*1*00000" + loopCounter + "*94608     ~");

                //TODO confirm Discharge Date ONLY goes in 2nd DTP segment
                transactionSet.setDTP("DTP*291*D8*" + d.getDischargeDate() + "~");
                transactionSet.setSE("SE*14*00000" + loopCounter + "~");

                // Write 2nd
                writeToFile(writer, transactionSet.getST());
                writeToFile(writer, transactionSet.getBHT());
                writeToFile(writer, transactionSet.getHL1());
                writeToFile(writer, transactionSet.getNM1());
                writeToFile(writer, transactionSet.getHL2());
                writeToFile(writer, transactionSet.getNM2());
                writeToFile(writer, transactionSet.getHL3());
                writeToFile(writer, transactionSet.getTRN());
                writeToFile(writer, transactionSet.getNM3());
                writeToFile(writer, transactionSet.getREF());
                writeToFile(writer, transactionSet.getDMG());
                writeToFile(writer, transactionSet.getDTP());
                writeToFile(writer, transactionSet.getEQ());
                writeToFile(writer, transactionSet.getSE());
            }
            // Close GS ISA
            writeToFile(writer,"GE*0000"+ loopCounter +"*13~");
            writeToFile(writer,"IEA*1*000001333~");
        } catch (IOException ex) {
            System.err.println("Problem writing to file EDI_FILE.txt");
        } finally {
            try {
                writer.close();
            } catch (Exception ex) {/* ignore */}
        }
    }

    private static void writeToFile(Writer w, String s) throws Exception {
        w.write(s + System.getProperty("line.separator"));
    }
}
