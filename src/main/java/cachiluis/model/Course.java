package cachiluis.model;

import datastructures.arraylist.MyArrayList;

public class Course {
    private String curseName;
    private MyArrayList<Student> students;
    private MyArrayList<Subject> subjects;


    public Course(String curseName) {
        this.curseName = curseName;
        this.students = new MyArrayList<>();
        this.subjects = new MyArrayList<>();
    }

    public Student getStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            Student index = students.get(i);
            if (index.toString() == studentId) {
                return index;
            }
        }
        return null;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    public Subject getSubject(String subjectName) {
        for (int i = 0; i < subjects.size(); i++) {
            Subject index = subjects.get(i);
            if (index.toString() == subjectName) {
                return index;
            }
        }
        return null;
    }

    public void setSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public String getCurseName() {
        return curseName;
    }

    @Override
    public String toString() {
        return curseName;
    }

}
