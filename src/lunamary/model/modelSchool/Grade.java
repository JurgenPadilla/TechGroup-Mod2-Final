package lunamary.model.modelSchool;

import lunamary.model.BaseModel;

public class Grade  extends BaseModel {


    private int grade;
    private String description;

    public Grade(int grade, String description) {
        this.grade = grade;
        this.description = description;
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
