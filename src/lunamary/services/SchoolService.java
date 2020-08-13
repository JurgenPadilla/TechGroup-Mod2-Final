package lunamary.services;

import datastructures.arraylist.MyArrayList;
import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import datastructures.hashmap.MyHashMap;
import lunamary.model.modelPerson.*;
import lunamary.model.modelSchool.*;
import lunamary.readWriteData.AbstractFactory;
import lunamary.readWriteData.ReadWriteFile;


public class SchoolService {
    private static SchoolService schoolService;
    private static School school;


    public SchoolService() {
        this.school = new School();

    }

    public SchoolService(String nameSchool, String address) {
        this.school = new School();
        this.setDataSchool(nameSchool, address);
    }

    public static SchoolService getSchoolService() {
        if (schoolService == null) {
            schoolService = new SchoolService();
        }
        return schoolService;
    }

    public static School getSchool() {
        return schoolService.school;
    }


    public void registerDirector(String name, String lastname, int ci, String gender) {
        DirectorService directorService = new DirectorService();
        Director director = directorService.createDirector(name, lastname, ci, gender);
        getSchoolService().getSchool().setDirector(director);

    }

    public static void registerClassroom(String id, String name) {
        ClassroomService classroomService = new ClassroomService();
        Classroom classroom = classroomService.crateClassroom(id, name);
        getSchoolService().getSchool().addClassroom(classroom);

    }

//    public static void assignParentStudent(String parentId, String StudentId) {
//        ParentService parentService = new ParentService();
//        Parent parent = parentService.createParent(name, lastName, ci);
//        school.addParent(parent);
//
//    }

    public static void assignParentStudent(int parentId, int StudentId, String codeClassroom) {
        Parent parent = SearchService.getParent(parentId);
        Classroom classroom = SearchService.getClassroom(codeClassroom);
        Student student = (Student) SearchService.getStudent(classroom, StudentId);
        StudentService studentService = new StudentService();
        studentService.setParent(student, parent);

    }

    public static void registerDevice(String type, String identifier, String name, String lastname, int ci) {
        Parent parent = SearchService.getParent(ci);
        DeviceService deviceService = new DeviceService();
        Device device = deviceService.createDevice(type, identifier, parent);
        getSchoolService().getSchool().addDevice(device);
    }


    public static void registerTeacher(String name, String lastname, int ci, String gender) {
        TeacherService teacherService = new TeacherService();
        Teacher teacher = teacherService.createTeacher(name, lastname, ci, gender);
        getSchoolService().getSchool().addTeacher(teacher);

    }

    public static void registerSubject(String nameSubject, String codeClassroom, int ciTeacher) {
        SubjectService subjectService = new SubjectService();
        Subject subject = subjectService.createSubject(nameSubject);
        Classroom classroom = SearchService.getClassroom(codeClassroom);
        Teacher teacher = SearchService.getTeacher(ciTeacher);
        subjectService.setTeacher(subject, teacher);
        classroom.addSubject(subject);


    }

    public static void registerAverageClassroom(String codeClassroom, int averageScholarshipGrade, int minimumAverageApprobation) {
        Classroom classroom = SearchService.getClassroom(codeClassroom);
        DirectorService directorService = new DirectorService();
        directorService.assignAverage(classroom, averageScholarshipGrade, minimumAverageApprobation);

    }

    public static void registerStudent(String codeClassroom, String name, String lastName, int ci, String gender, String nameParent,
                                       String lastNameParent, int ciParent, String typeDevice1, String identifier1,
                                       String typeDevice2, String identifier2, String genderParent) {

        ParentService parentService = new ParentService();
        Parent parent = parentService.createParent(nameParent, lastNameParent, ciParent, genderParent);

        DeviceService deviceService = new DeviceService();
        deviceService.createDevice(typeDevice1, identifier1, parent);
        deviceService.createDevice(typeDevice2, identifier2, parent);

        Classroom classroom = SearchService.getClassroom(codeClassroom);
        StudentService studentService = new StudentService();
        Student student = studentService.createStudent(name, lastName, ci, gender);
        studentService.setParent(student, parent);
        ClassroomService classroomService = new ClassroomService();
        classroomService.setStudent(classroom, student);


    }

    public void assignGradeStudent(String codeClassroom, int ciTeacher, int grade, String description, int ciStudent, String nameSubject, String year) {

        Classroom classroom = SearchService.getClassroom(codeClassroom);
        GradeService gradeService = new GradeService();
        Grade newGrade = gradeService.createGrade(grade, description);
        Teacher teacher = SearchService.getTeacher(ciTeacher);
        Student student = SearchService.getStudent(classroom, ciStudent);
        Subject subject = SearchService.getSubject(classroom, nameSubject);
        TeacherService teacherService = new TeacherService();
        GradeStudent gradeStudent = teacherService.createGradeStudent(teacher, student, subject, year, newGrade);
        getSchoolService().getSchool().addGradeStudent(gradeStudent);


    }

    public boolean importGradeFromFile(String pathFile) {
        boolean isImportSucess = false;
        MyArrayList<MyHashMap<String, String>> data = importDataFromFile(pathFile);

        if (!data.isEmpty()) {
            for (int i = 0; i < data.size(); i++) {
                MyHashMap<String, String> entry = data.get(i);

                int ciTeacher = Integer.parseInt(entry.get("ciTeacher"));
                String nameClassroom = entry.get("nameClassroom");
                String subject = entry.get("subject");
                int ciStudent = Integer.parseInt(entry.get("ciStudent"));
                int grade = Integer.parseInt(entry.get("grade"));
                String year = entry.get("year");
                this.assignGradeStudent(nameClassroom, ciTeacher, grade, "IMPORT GRADE", ciStudent, subject, year);

            }
            isImportSucess = true;
        }
        return isImportSucess;

    }

    public void computeAverageStudents(String year) {
        KardexService kardexService = new KardexService();
        MyCircularDoublyLinkedList list = schoolService.getSchool().getClassroomList();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Classroom room = (Classroom) list.get(i);
                MyCircularDoublyLinkedList listStudents = room.getStudentList();
                if (listStudents.size() > 0) {
                    for (int j = 0; j < listStudents.size(); j++) {
                        Student student = (Student) listStudents.get(j);
                        int finalAverage = computeAverageStudent(student, year);
                        Kardex kardex = kardexService.createKardex(student, room, finalAverage, year);
                        getSchoolService().getSchool().addKardex(kardex);

                    }
                }

            }
        }

    }

    public int computeAverageStudent(Student student, String year) {
        int finalAverage = 0;
        int total = 0;
        int cont = 0;
        MyCircularDoublyLinkedList list = schoolService.getSchool().getGradeStudentList();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                GradeStudent gradeStudent = (GradeStudent) list.get(i);
                if (gradeStudent.getStudent().getId() == student.getId() && gradeStudent.getYear() == year) {
                    total += gradeStudent.getGrade().getGrade();
                    cont++;
                }
            }
        }
        finalAverage = total / cont;
        return finalAverage;
    }


    public MyArrayList<MyHashMap<String, String>> importDataFromFile(String path) {
        ReadWriteFile file = AbstractFactory.createFile(path);
        if (file == null) {
            return null;
        } else {
            return file.readLines();
        }
    }

    public boolean exportDataToFile(String path, MyArrayList<MyHashMap<String, String>> values) {
        ReadWriteFile file = AbstractFactory.createFile(path);
        if (file == null) {
            return false;
        } else {
            return file.writeEntries(values);
        }
    }


    public void setDataSchool(String name, String address) {
        getSchool().setName(name);
        getSchool().setAddress(address);
    }
}


