package lunamary.services;

import lunamary.model.modelPerson.Director;
import lunamary.model.modelPerson.Teacher;
import lunamary.model.modelSchool.Classroom;
import lunamary.model.modelSchool.Subject;


public class SubjectService {

    public SubjectService() {
    }

    public Subject createSubject(String name) {
        Subject subject = new Subject(name);
        return subject;
    }

    public void setTeacher(Subject subject, Teacher teacher) {
        subject.setTeacher(teacher);

    }
}
