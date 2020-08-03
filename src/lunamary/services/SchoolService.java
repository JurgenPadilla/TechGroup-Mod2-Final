package lunamary.services;

import lunamary.modelPerson.*;
import lunamary.modelSchool.*;
;import java.util.ArrayList;
import java.util.List;

public class SchoolService {

    private static School school;
    private static Director director;


    public SchoolService() {

    }

    public School createSchool(String name, String address) {
        School school = new School(name, address);
        return school;
    }

    public void registerDirector(String name, String lastname, int ci) {
        DirectorService directorService = new DirectorService();
        director = directorService.createDirector(name, lastname, ci);
        school.setDirector(director);

    }

    public static void registerClassroom(String id, String name) {
        ClassroomService classroomService = new ClassroomService();
        Classroom classroom = classroomService.crateClassroom(id, name);
        school.addClassroom(classroom);
    }

    public static void registerParent(String name, String lastName, int ci) {
        ParentService parentService = new ParentService();
        Parent parent = parentService.createParent(name, lastName, ci);
        school.addParent(parent);

    }

    public static void registerDevice(String type, String identifier, String name, String lastname, int ci) {
        Parent parent = CommonService.getParent(school, ci);
        DeviceService deviceService = new DeviceService();
        Device device = deviceService.createDevice(type, identifier, parent);
        school.addDevice(device);
    }


    public static void registerTeacher(String name, String lastname, int ci) {
        TeacherService teacherService = new TeacherService();
        Teacher teacher = teacherService.createTeacher(name, lastname, ci);
        school.addTeacher(teacher);
    }

    public static void registerSubject(String nameSubject, String codeClassroom, int ciTeacher) {
        SubjectService subjectService = new SubjectService();
        Subject subject = subjectService.createSubject(nameSubject);
        Classroom classroom = CommonService.getClassroom(school, codeClassroom);
        Teacher teacher = CommonService.getTeacher(school, ciTeacher);
        subjectService.setTeacher(subject, teacher);
        classroom.addSubject(subject);

    }

    public static void registerAverageClassroom(String codeClassroom, int averageScholarshipGrade, int minimumAverageApprobation) {
        Classroom classroom = CommonService.getClassroom(school, codeClassroom);
        DirectorService directorService = new DirectorService();
        directorService.assignAverage(classroom, averageScholarshipGrade, minimumAverageApprobation);

    }

    public static void registerStudent(String codeClassroom, String name, String lastName, int ci, String nameParent,
                                       String lastNameParent, int ciParent, String typeDevice1, String identifier1,
                                       String typeDevice2, String identifier2) {

        ParentService parentService = new ParentService();
        Parent parent = parentService.createParent(nameParent, lastNameParent, ciParent);

        DeviceService deviceService = new DeviceService();
        deviceService.createDevice(typeDevice1, identifier1, parent);
        deviceService.createDevice(typeDevice2, identifier2, parent);

        Classroom classroom = CommonService.getClassroom(school, codeClassroom);
        StudentService studentService = new StudentService();
        Student student = studentService.createStudent(name, lastName, ci);
        studentService.setParent(student, parent);
        ClassroomService classroomService = new ClassroomService();
        classroomService.setStudent(classroom, student);


    }

    public void assignGradeStudent(String codeClassroom, int ciTeacher, int grade1, String description1, int grade2, String description2, int ciStudent, String nameSubject, String year) {

        Classroom classroom = CommonService.getClassroom(school, codeClassroom);
        GradeService gradeService = new GradeService();
        Grade first_test = gradeService.createGrade(grade1, description1);
        Grade second_test = gradeService.createGrade(grade2, description2);
        List<Grade> grades = new ArrayList<>();
        grades.add(first_test);
        grades.add(second_test);
        Teacher teacher = CommonService.getTeacher(school, ciTeacher);
        Student student = CommonService.getStudent(classroom, ciStudent);
        Subject subject = CommonService.getSubject(classroom, nameSubject);
        TeacherService teacherService = new TeacherService();
        GradeStudent gradeStudent = teacherService.createGradeStudent(teacher, student, subject, year, grades);
        school.addGradeStudent(gradeStudent);


    }

}


