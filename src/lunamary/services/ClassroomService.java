package lunamary.services;

import lunamary.model.modelPerson.Student;
import lunamary.model.modelSchool.Classroom;

public class ClassroomService {

    public ClassroomService() {
    }

    public Classroom crateClassroom(String codeClassroom, String name) {
        Classroom classroom = new Classroom(codeClassroom, name);
        return classroom;
    }


    public void setStudent(Classroom classroom, Student student) {
        classroom.addStudent(student);
    }

}
