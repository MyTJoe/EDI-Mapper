import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import java.io.*;
import java.util.*;

public class Main {
    private static final String ediFileLocationPC = System.getenv("LOCATION");
    private static final String ediFileLocationMac = System.getenv("LOCATION2") + "test_file.csv";


    public static void main(String[] args) throws Exception {
        System.out.println(ediFileLocationMac);
        String dataString = "";
        HeaderColumnNameMappingStrategy<Data> mappingStrategy = new HeaderColumnNameMappingStrategy<Data>();
        //CsvToBean<Data> csvToBean = new CsvToBean<Data>();

        List<Data> dataList = new CsvToBeanBuilder<Data>(new FileReader(ediFileLocationMac))
                .withType(Data.class).build().parse();

        for (Data d : dataList) {
            System.out.println(d.getPatientSSN());
        }

        //CsvToBean csvToBean = new CsvToBeanBuilder(new FileReader(ediFileLocationMac)).build();





        dataString = "jkhgkjhg";
    }
}
//CSVReader reader = new CSVReader(new FileReader(ediFileLocationMac + "test_file.csv"));
// CSVIterator iterator = new CSVIterator(reader);
//Writer writer = null;

/*
//        try {
//            writer = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream("filename.txt"), "utf-8"));
//            writer.write("Something");
//        } catch (IOException ex) {
//            System.err.println("Problem writing to the file filename.txt");
//        } finally {
//            try {writer.close();} catch (Exception ex) {/*ignore}
//        }
        System.out.println(Arrays.toString(reader.readNext()));
        Map<String, Integer> map = new HashMap<String, Integer>();



        List<Data> list = csvToBean.iterator();

        int count = 0;
        while (iterator.hasNext()) {
        String[] result = iterator.next();
        if (count == 0) {
        int index = 0;
        for (String s : result) {
        System.out.println(s.toUpperCase());
        map.put(s.toUpperCase(), index);
        index++;
        }
        }
        System.out.println(Arrays.toString(result));
        System.out.println();
        System.out.println(result.length);

        count++;
        }
        System.out.println(map);
        System.out.println(map.size());


 */