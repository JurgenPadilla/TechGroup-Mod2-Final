

package lunamary.model.modelSchool;

import lunamary.model.BaseModel;
import lunamary.model.modelPerson.Student;
import lunamary.model.modelPerson.Teacher;

import java.util.List;

public class GradeStudent extends BaseModel {

    private Teacher teacher;
    private List<Grade> gradeList;
    private Student student;
    private String year;
    private Subject subject;

    public GradeStudent(List<Grade> gradeList, Student student, String year, Subject subject, Teacher teacher) {
        this.gradeList = gradeList;
        this.student = student;
        this.year = year;
        this.subject = subject;
        this.teacher = teacher;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
