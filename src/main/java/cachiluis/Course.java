package cachiluis;

import datastructures.hashmap.MyHashMap;

public class Course {
    String curseName;
    MyHashMap<String, Subject> subjects = new MyHashMap<>();
}
