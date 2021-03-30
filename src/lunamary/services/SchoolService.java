package lunamary.services;

import datastructures.arraylist.MyArrayList;
import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import datastructures.hashmap.MyHashMap;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.*;
import lunamary.model.modelSchool.*;
import lunamary.readWriteData.AbstractFactory;
import lunamary.readWriteData.ReadWriteFile;

import java.util.HashMap;
import java.util.Map;


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

    public static School getSchoolService() {
        if (school == null) {
            school = new School();
        }
        return school;
    }

    public static School getSchool() {
        return schoolService.school;
    }


    public void registerDirector(String name, String lastname, int ci, String gender) {
        DirectorService directorService = new DirectorService();
        Director director = directorService.createDirector(name, lastname, ci, gender);
        getSchoolService().setDirector(director);

    }

    public static void registerClassroom(String codeClassroom, String name) {
        ClassroomService classroomService = new ClassroomService();
        Classroom classroom = classroomService.crateClassroom(codeClassroom, name);
        getSchoolService().addClassroom(classroom);

    }


    public static void assignParentStudent(int parentId, int StudentId, String codeClassroom) {
        Parent parent = SearchService.getParent(parentId);
        Classroom classroom = SearchService.getClassroom(codeClassroom);
        Student student = (Student) SearchService.getStudent(classroom, StudentId);
        StudentService studentService = new StudentService();
        studentService.setParent(student, parent);

    }

    public static void registerDevice(String type, String identifier, String name, String lastName, int ci) {
        Parent parent = SearchService.getParent(ci);
        DeviceService deviceService = new DeviceService();
        Device device = deviceService.createDevice(type, identifier);
        getSchoolService().addDevice(device);
    }


    public static void registerTeacher(String name, String lastname, int ci, String gender) {
        TeacherService teacherService = new TeacherService();
        Teacher teacher = teacherService.createTeacher(name, lastname, ci, gender);
        getSchoolService().addTeacher(teacher);

    }

    public static void registerSubject(String nameSubject, String codeClassroom, int ciTeacher) {
        SubjectService subjectService = new SubjectService();
        Subject subject = subjectService.createSubject(nameSubject);
        Classroom classroom = SearchService.getClassroom(codeClassroom);
        Teacher teacher = SearchService.getTeacher(ciTeacher);
        subjectService.setTeacher(subject, teacher);
        classroom.addSubject(subject);


    }

    public static void registerAverageClassroom(String codeClassroom, int averageScholarshipGrade, int minimumAverageApprobation, int expelled) {
        Classroom classroom = SearchService.getClassroom(codeClassroom);
        DirectorService directorService = new DirectorService();
        directorService.assignAverage(classroom, averageScholarshipGrade, minimumAverageApprobation, expelled);

    }

    public static void registerStudent(String codeClassroom, String name, String lastName, int ci, String gender, String nameParent,
                                       String lastNameParent, int ciParent, String typeDevice1, String identifier1,
                                       String typeDevice2, String identifier2, String genderParent) {

        ParentService parentService = new ParentService();
        Parent parent = parentService.createParent(nameParent, lastNameParent, ciParent, genderParent);
        getSchoolService().addParent(parent);

        DeviceService deviceService = new DeviceService();
        Device device1 = deviceService.createDevice(typeDevice1, identifier1);
        deviceService.createDevice(typeDevice2, identifier2);
        parent.setDevice(device1);

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
        getSchoolService().addGradeStudent(gradeStudent);


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
        schoolService.getSchool().setKardexList(new MyCircularDoublyLinkedList<>());
        schoolService.getSchool().setKardexHashMap(new HashMap<>());

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
                        getSchoolService().addKardex(kardex);
                        addkardexOrderByDesc(kardex);
                        student.setStatus(evaluateAverage(room, finalAverage));

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
                if (gradeStudent.getStudent().getId() == student.getId() && gradeStudent.getYear().equals(year)) {
                    total += gradeStudent.getGrade().getGrade();
                    cont++;

                }
            }

        }

        finalAverage = total != 0 ? total / cont : 0;
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

    public boolean exportDataToFile(String path, Map<String, MyLinkedList<Kardex>> values) {
        ReadWriteFile file = AbstractFactory.createFile(path);
        if (file == null) {
            return false;
        } else {
            return file.writeLines(values);
        }
    }


    public void setDataSchool(String name, String address) {
        getSchool().setName(name);
        getSchool().setAddress(address);
    }

    public HashMap<String, MyLinkedList<Kardex>> addkardexOrderByDesc(Kardex kardex) {
        HashMap<String, MyLinkedList<Kardex>> hashKardex = school.getKardexHashMap();
        MyLinkedList<Kardex> listKardex = new MyLinkedList<>();
        if (hashKardex.containsKey(kardex.getClassroom().getCode()) == false) {
            listKardex.add(kardex);
            hashKardex.put(kardex.getClassroom().getCode(), listKardex);
        } else {
            listKardex = hashKardex.get(kardex.getClassroom().getCode());
            addOrderKardexList(kardex, listKardex);
            hashKardex.put(kardex.getClassroom().getCode(), listKardex);
        }
        return hashKardex;
    }

    public void addOrderKardexList(Kardex kardex, MyLinkedList<Kardex> listKardex) {

        if (listKardex.size() == 1) {
            if (listKardex.get(0).getFinalAverage() > kardex.getFinalAverage()) {
                listKardex.add(kardex);
            } else {
                listKardex.add(0, kardex);
            }
        } else {
            boolean isInsert = false;
            int index = 0;
            int endIndex = listKardex.size() - 1;
            while (!isInsert) {

                int thisValue = listKardex.get(index).getFinalAverage();
                int nextValue = ((index + 1) < endIndex) ? listKardex.get(index + 1).getFinalAverage() : -1;
                if (kardex.getFinalAverage() > thisValue) {
                    listKardex.add(index, kardex);
                    isInsert = true;
                } else if (nextValue == -1) {
                    listKardex.add(index + 1, kardex);
                    isInsert = true;
                } else if (kardex.getFinalAverage() > thisValue && kardex.getFinalAverage() < nextValue) {
                    listKardex.add(index + 1, kardex);
                    isInsert = true;
                }

                index++;
            }
        }

    }


    public String evaluateAverage(Classroom classroom, int average) {
        String status = "";
        int expelled = classroom.getAverageExpelled();
        int scholarship = classroom.getAverageScholarshipGrade();
        int approvedMin = classroom.getMinimumAverageApprobation();

        if (average <= expelled) {
            status = "EXPELLED";
        } else if (average <= approvedMin) {
            status = "FAILED";
        } else if (average < scholarship) {
            status = "PASSED";
        } else if (average == scholarship) {
            status = "SCHOLAR";
        }
        return status;

    }

    public void notifyDevices() {
        NotificationService notificationService = new NotificationService();
        notificationService.registerObservers();
        notificationService.notifyObservers();
    }


    public void editGradeStudent(int grade, String description, int ciStudent, String nameSubject) {
        GradeService gradeService = new GradeService();
        Grade newGrade = gradeService.createGrade(grade, description);

        GradeStudent gradeStudent = SearchService.getGradeStudent(ciStudent, nameSubject);
        gradeStudent.setGrade(newGrade);

    }

}


