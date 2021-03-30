package lunamary.services;

import lunamary.model.modelSchool.Grade;


public class GradeService {

    public GradeService() {
    }

    public Grade createGrade(int gradeStudent, String description) {
        Grade grade = new Grade(gradeStudent, description);
        return grade;
    }


}
