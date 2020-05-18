package cachiluis;

import datastructures.hashmap.MyHashMap;

public class Kardex {
    private double average;
    private Student student;
    private String id;
    private MyHashMap<String, Subject> subjects;

    public Kardex(String Id, String studentName) {
        student = new Student(Id, studentName);
        id = student.getId();
    }

    public Subject getSubject(String subjectName) {
        return subjects.get(subjectName);
    }

    public boolean setGradesForSubject(String subjectName, int period, int grade) {
        Subject subject = getSubject(subjectName);
        if (subject == null) {
            subject = new Subject(subjectName);
            subjects.put(subjectName, subject);
        }
        subject.registerGrades(period, grade);
        return true;
    }

    public String getId(){
        return id;
    }
}
