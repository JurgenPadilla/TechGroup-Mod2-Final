package lunamary.readWriteData;

import datastructures.arraylist.MyArrayList;
import datastructures.hashmap.MyHashMap;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.Kardex;

import java.util.Map;

public abstract class ReadWriteFile {
    protected String path;

    public ReadWriteFile(String path) {
        this.path = path;
    }


    public abstract MyArrayList<MyHashMap<String, String>> readLines();

    public abstract boolean writeLines(Map<String, MyLinkedList<Kardex>>  lines);
}
