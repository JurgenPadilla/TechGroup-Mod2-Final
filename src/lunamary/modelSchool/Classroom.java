package lunamary.modelSchool;

import lunamary.modelPerson.Student;
import lunamary.modelPerson.Teacher;

import java.util.List;

public class Classroom {
    private List<Subject> subjectList;
    private List<Student> studentList;

    private int averageScholarshipGrade;
    private int minimumAverageApprobation;
    private String name;


    public Classroom(List<Subject> subjectList, String name, List<Student> studentList) {
        this.subjectList = subjectList;
        this.name = name;
        this.studentList = studentList;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }


}
