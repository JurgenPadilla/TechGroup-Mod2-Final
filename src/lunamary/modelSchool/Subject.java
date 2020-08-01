package lunamary.modelSchool;

import lunamary.modelPerson.Director;
import lunamary.modelPerson.Student;
import lunamary.modelPerson.Teacher;

import java.util.List;

public class Subject {
    private String name;
    private Teacher teacher;


    public Subject(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;

    }

    public Subject(Teacher teacher, String name) {
        this.name = name;
        this.teacher = teacher;
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
