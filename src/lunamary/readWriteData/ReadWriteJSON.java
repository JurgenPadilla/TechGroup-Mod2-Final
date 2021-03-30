package lunamary.readWriteData;

import datastructures.arraylist.MyArrayList;
import datastructures.hashmap.MyHashMap;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.Kardex;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ReadWriteJSON extends ReadWriteFile {

    public ReadWriteJSON(String path) {
        super(path);
    }

    @Override
    public MyArrayList<MyHashMap<String, String>> readLines() {

        MyArrayList<MyHashMap<String, String>> records = new MyArrayList<>();
        try {
            JSONTokener tokener = new JSONTokener(new FileReader(this.path));
            JSONArray jsonArray = new JSONArray(tokener);

            for (int i = 0; i < jsonArray.length(); i++) {
                MyHashMap<String, String> entry = new MyHashMap<>();
                JSONObject data = (JSONObject) jsonArray.get(i);
                Iterator<String> keys = data.keys();
                while (keys.hasNext()) {
                    String key = keys.next();
                    entry.put(key, data.get(key).toString());
                }
                records.add(entry);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return records;
    }

    @Override
    public boolean writeLines(Map<String, MyLinkedList<Kardex>> dataStudent) {

        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.path));
            JSONArray objectsArray = new JSONArray();
            if (!dataStudent.isEmpty()) {

                for (MyLinkedList<Kardex> listStudent : dataStudent.values()) {
                    LinkedList<Object> valueObject = new LinkedList<>();
                    for (int i = 0; i < listStudent.getSize(); i++) {
                        JSONObject object = new JSONObject();
                        String classroom = listStudent.get(i).getClassroom().getCode();
                        String name = listStudent.get(i).getStudent().getName() + " " + listStudent.get(i).getStudent().getName();
                        int average = listStudent.get(i).getFinalAverage();
                        String status = listStudent.get(i).getStudent().getStatus();
                        object.put("status", status);
                        object.put("classroom", classroom);
                        object.put("name", name);
                        object.put("average", average);
                        valueObject.add(object);
                    }
                    objectsArray.put(valueObject);
                }

            }
            objectsArray.write(writer);
            writer.close();
            return true;
        } catch (
                Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
