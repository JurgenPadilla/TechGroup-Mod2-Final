package lunamary.services;

import lunamary.model.modelPerson.Student;
import lunamary.model.modelPerson.Teacher;
import lunamary.model.modelSchool.Grade;
import lunamary.model.modelSchool.GradeStudent;
import lunamary.model.modelSchool.Subject;

import java.util.List;

public class GradeStudentService {


    public GradeStudent createGradeStudent(Grade grade, Student student, String year, Subject subject, Teacher teacher) {
        GradeStudent gradeStudent = new GradeStudent(grade, student, year, subject, teacher);
        return gradeStudent;
    }




}
