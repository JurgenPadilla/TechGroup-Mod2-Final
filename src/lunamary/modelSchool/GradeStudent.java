

package lunamary.modelSchool;

import lunamary.modelPerson.Student;

import java.util.Date;
import java.util.List;

public class GradeStudent {
    private List<Grade> gradeList;
    private Student student;
    private String year;

    public GradeStudent(List<Grade> gradeList, Student student, String year) {
        this.gradeList = gradeList;
        this.student = student;
        this.year = year;
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
}
