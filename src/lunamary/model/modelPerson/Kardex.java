package lunamary.model.modelPerson;

import lunamary.model.BaseModel;
import lunamary.model.modelSchool.Classroom;

public class Kardex extends BaseModel {

    private Student student;
    private Classroom classroom;
    private int finalAverage;
    private String year;


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public int getFinalAverage() {
        return finalAverage;
    }

    public void setFinalAverage(int finalAverage) {
        this.finalAverage = finalAverage;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public Kardex() {

    }


}
