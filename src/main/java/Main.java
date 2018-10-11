import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class Main {
    private static final String ediFileLocation = System.getenv("LOCATION");

    public static void main(String[] args) throws Exception {
        CSVReader reader = new CSVReader(new FileReader(ediFileLocation + "\\edi_test_file.csv"));
        CSVIterator iterator = new CSVIterator(reader);

        while (iterator.hasNext()) {
            String[] result = iterator.next();
            System.out.println(Arrays.toString(result));
        }
    }
}
