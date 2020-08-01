package lunamary.modelSchool;

import lunamary.modelPerson.Director;

import java.util.List;

public class School {

    private String name;
    private Director director;
    private List<Classroom> classroomList;
    private List<GradeStudent> gradeStudentList;


    public School(String name, Director director, List<Classroom> classroomList, List<GradeStudent> gradeStudentList) {
        this.name = name;
        this.classroomList = classroomList;
        this.director = director;
        this.gradeStudentList = gradeStudentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public List<GradeStudent> getGradeStudentList() {
        return gradeStudentList;
    }

    public void setGradeStudentList(List<GradeStudent> gradeStudentList) {
        this.gradeStudentList = gradeStudentList;
    }


}
