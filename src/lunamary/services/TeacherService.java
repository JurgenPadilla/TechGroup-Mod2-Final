package lunamary.services;

import lunamary.model.modelPerson.Student;
import lunamary.model.modelPerson.Teacher;
import lunamary.model.modelSchool.Grade;
import lunamary.model.modelSchool.GradeStudent;
import lunamary.model.modelSchool.Subject;

import java.util.List;

public class TeacherService {

    public TeacherService() {

    }

    public Teacher createTeacher(String name, String lastName, int age, String gender) {
        Teacher teacher = new Teacher(name, lastName, age, gender);
        return teacher;
    }


    public GradeStudent createGradeStudent(Teacher teacher, Student student, Subject subject, String year, Grade grade) {
        GradeStudentService gradeStudentService = new GradeStudentService();
        GradeStudent gradeStudent = gradeStudentService.createGradeStudent(grade, student, year, subject, teacher);
        return gradeStudent;
    }


}
