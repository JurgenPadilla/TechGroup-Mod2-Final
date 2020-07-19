package cachiluis.model;

import datastructures.hashmap.MyHashMap;

public class Kardex {
    private Student student;
    private String reasons;
    private MyHashMap<String, Integer> grades;

    public Kardex(Student student) {
        this.student = student;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public int getGrades(String period) {
        return grades.get(period);
    }

    public void setGrades(String period, int grade) {
        this.grades.put(period, grade);
    }

    public Student getStudent() {
        return student;
    }
}
