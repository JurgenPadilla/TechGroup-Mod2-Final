package cachiluis.services.readfile;

import datastructures.hashmap.MyHashMap;

// by default the Studens has 4 periods of notes: note of the two months: 1, 2, 3, 4
public class RegisterNotes {
    private String studentId;
    private MyHashMap<Integer, Integer> grades;
    private double average;

    public RegisterNotes() {
        this.grades = new MyHashMap<>();
    }

    //@deprecated
    public RegisterNotes(String studentId) {
        this.studentId = studentId;
        this.grades = new MyHashMap<>();
    }

    public void setGrades(int period, int grade) {
        this.grades.put(period, grade);
    }

    public void printNotes() {
        //
    }
}
