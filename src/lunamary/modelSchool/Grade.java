package lunamary.modelSchool;

import lunamary.services.SubjectObservable;

public class Grade extends SubjectObservable {


    private int grade;
    private String description;

    public Grade() {
        super();

    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {

        this.grade = grade;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
