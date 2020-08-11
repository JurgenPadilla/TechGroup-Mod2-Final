package lunamary.model.modelSchool;

import lunamary.model.BaseModel;
import lunamary.model.modelPerson.Director;
import lunamary.model.modelPerson.Student;
import lunamary.model.modelPerson.Teacher;

public class Subject extends BaseModel {
    private String name;
    private Teacher teacher;


    public Subject(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
