package lunamary.readWriteData;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import datastructures.arraylist.MyArrayList;
import datastructures.hashmap.MyHashMap;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.Kardex;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Map;

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
    public boolean writeLines(Map<String, MyLinkedList<Kardex>> entries) {

        try {
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(this.path), StandardCharsets.UTF_8),
                    ',',
                    CSVWriter.DEFAULT_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            if (!entries.isEmpty()) {
                String[] headers = {"CLASSROOM","NAME","AVERANGE","STATUS"};
                writer.writeNext(headers);
                for (MyLinkedList<Kardex> listStudent : entries.values()) {
                    for (int i = 0; i < listStudent.getSize(); i++) {
                        String classroom = listStudent.get(i).getClassroom().getCode();
                        String name = listStudent.get(i).getStudent().getName() + " " + listStudent.get(i).getStudent().getName();
                        int average = listStudent.get(i).getFinalAverage();
                        String status = listStudent.get(i).getStudent().getStatus();
                        String row []={classroom, name, average + "", status};
                        writer.writeNext(row);
                    }
                }
            } else {
                writer.writeNext(new String[]{""});
            }
            writer.close();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
