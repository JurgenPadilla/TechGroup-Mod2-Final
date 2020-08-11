package lunamary.readWriteData;

import com.opencsv.CSVReader;
import datastructures.arraylist.MyArrayList;
import datastructures.hashmap.MyHashMap;

import java.io.FileReader;

public class ReadWriteCSV extends ReadWriteFile {

    public ReadWriteCSV(String path) {
        super(path);
    }

    @Override
    public MyArrayList<MyHashMap<String, String>> readLines() {
        MyArrayList<MyHashMap<String, String>> entries = new MyArrayList<>();
        CSVReader csvReader;
        try {
            csvReader = new CSVReader(new FileReader(this.path));
            String[] headers = csvReader.readNext();
            String[] line = csvReader.readNext();
            while (line != null) {
                MyHashMap<String, String> entry = new MyHashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    entry.put(headers[i], line[i]);
                }
                entries.add(entry);
                line = csvReader.readNext();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return entries;

    }

    @Override
    public boolean writeEntries(MyArrayList<MyHashMap<String, String>> lines) {
        return false;
    }
}
