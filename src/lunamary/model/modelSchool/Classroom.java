package lunamary.model.modelSchool;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.BaseModel;
import lunamary.model.modelPerson.Student;

public class Classroom extends BaseModel {

    private MyCircularDoublyLinkedList<Student> studentList;
    private MyCircularDoublyLinkedList<Subject> subjectList;
    private int averageScholarshipGrade;
    private int minimumAverageApprobation;
    private int averageExpelled;
    private String name;
    private String code;


    public Classroom(String code, String name) {
        this.code = code;
        this.name = name;
        this.subjectList = new MyCircularDoublyLinkedList<>();
        this.studentList = new MyCircularDoublyLinkedList<>();
    }

    public MyCircularDoublyLinkedList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(MyCircularDoublyLinkedList<Student> studentList) {
        this.studentList = studentList;
    }

    public MyCircularDoublyLinkedList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(MyCircularDoublyLinkedList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public int getAverageScholarshipGrade() {
        return averageScholarshipGrade;
    }

    public void setAverageScholarshipGrade(int averageScholarshipGrade) {
        this.averageScholarshipGrade = averageScholarshipGrade;
    }

    public int getMinimumAverageApprobation() {
        return minimumAverageApprobation;
    }

    public void setMinimumAverageApprobation(int minimumAverageApprobation) {
        this.minimumAverageApprobation = minimumAverageApprobation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAverageExpelled() {
        return averageExpelled;
    }

    public void setAverageExpelled(int averageExpelled) {
        this.averageExpelled = averageExpelled;
    }


    public void addSubject(Subject subject) {
        this.subjectList.add(subject);
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }
}
