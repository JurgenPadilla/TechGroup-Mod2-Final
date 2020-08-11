package lunamary.readWriteData;

import datastructures.arraylist.MyArrayList;
import datastructures.hashmap.MyHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.Iterator;

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
    public boolean writeEntries(MyArrayList<MyHashMap<String, String>> lines) {
        return false;
    }


}
