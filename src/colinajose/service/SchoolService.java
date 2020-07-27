package colinajose.service;

import colinajose.data.DataIO;
import colinajose.model.people.Contact;
import colinajose.model.people.Device;
import colinajose.model.people.Parent;
import colinajose.model.people.Person;
import colinajose.model.people.Student;
import colinajose.model.people.Teacher;
import colinajose.model.schoolEntities.Course;
import colinajose.model.schoolEntities.Grade;
import colinajose.model.schoolEntities.Kardex;
import colinajose.model.schoolEntities.School;
import colinajose.model.schoolEntities.Subject;
import datastructures.arraylist.MyArrayList;
import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import datastructures.hashmap.MyHashMap;
import datastructures.linkedlist.MyLinkedList;

public class SchoolService {
    private School school;
    private ObservableService observable;
    private DataIO dataHandler;

    public SchoolService(){
        this.observable = new ObservableService();
        this.dataHandler = new DataIO();
    }

    public void createSchool(String name, String address, String phone, String email){
        Contact contact = new Contact(address, phone, email);
        this.school = new School(name, contact);
    }
    public String enrollStudent(String name, String ci, int age, String gender, String kardexId, String parentId, String address, String phone, String email){
        Contact contact = new Contact(address, phone, email);
        Student student = new Student(name, ci, age, gender, contact);
        Parent parent = SearchService.getParent(this.school, parentId);
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        student.addParent(parent);
        kardex.addStudent(student);
        return student.getId();
    }
    public String registerKardex(String courseId){
        Course course = SearchService.getCourse(this.school, courseId);
        Kardex kardex = new Kardex(course);
        this.school.addKardex(kardex);
        return kardex.getId();
    }
    public String registerCourse(String grade, String year, String group){
        Course course = new Course(grade, year, group);
        this.school.addCourse(course);
        return course.getId();
    }
    public String registerParent(String name, String ci, int age, String gender, String address, String phone, String email){
        Contact contact = new Contact(address, phone, email);
        Parent parent = new Parent(name, ci, age, gender, contact);
        this.school.addParent(parent);
        return parent.getId();
    }
    public String registerSubject(String topic, String courseId, String teacherId){
        Subject subject = new Subject(topic);
        Course course = SearchService.getCourse(school, courseId);
        Teacher teacher = getTeacher(teacherId);
        subject.setTeacher(teacher);
        course.addSubject(subject);
        return subject.getId();
    }
    public String registerTeacher(String name, String ci, int age, String gender, String address, String phone, String email){
        Contact contact = new Contact(address, phone, email);
        Teacher teacher = new Teacher(name, ci, age, gender, contact);
        school.addTeacher(teacher);
        return teacher.getId();
    }
    public String registerDevice(String personId, String phoneNumber){
        Person person = SearchService.getParent(this.school, personId);
        Device device = new Device(person, phoneNumber);
        this.school.addDevice(device);
        return device.getId();
    }
    public void setGradingScale(String courseId, double scholarship, double expelled, double notify){
        Course course = SearchService.getCourse(this.school, courseId);
        GradesService.setGradingScale(course, scholarship, expelled, notify);
    }
    public void computeGrades(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        MyCircularDoublyLinkedList<Grade> grades = GradesService.computeGrades(kardex);
        GradesService.computeStudentStates(kardex, grades);
    }
    public void updateNotifyList(String kardexId){
        MyLinkedList<Device> devicesToNotify = getDevicesToNotify(kardexId);
        registerObservers(devicesToNotify);
        MyLinkedList<Device> devicesToDetach = getDevicesToDetach(kardexId);
        removeObservers(devicesToDetach);
    }
    public void sendNotifications(){
        this.observable.notifyObservers();
    }
    private MyLinkedList<Device> getDevicesToDetach(String kardexId){
        MyLinkedList<Student> students = new MyLinkedList<>();
        students.addAll(getAverageStudents(kardexId));
        students.addAll(getScholarshipStudents(kardexId));
        students.addAll(getExpelledStudents(kardexId));
        return getDevices(students);
    }
    private MyLinkedList<Device> getDevicesToNotify(String kardexId) {
        MyLinkedList<Student> students = new MyLinkedList<>();
        students.addAll(getNotifyStudents(kardexId));
        return getDevices(students);
    }
    private MyLinkedList<Device> getDevices(MyLinkedList<Student> students){
        MyLinkedList<Device> devices = new MyLinkedList<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            MyCircularDoublyLinkedList<Person> parents = student.getParents();
            for (int j = 0; j < parents.size(); j++) {
                devices.addAll(SearchService.getDevices(this.school, parents.get(i)));
            }
        }
        return devices;
    }
    private void removeObservers(MyLinkedList<Device> devices){
        for (int i = 0; i < devices.size(); i++) {
            Device device = devices.get(i);
            this.observable.removeObserver(new DeviceService(device));
        }
    }
    private void registerObservers(MyLinkedList<Device> devices){
        for (int i = 0; i < devices.size(); i++) {
            Device device = devices.get(i);
            this.observable.registerObserver(new DeviceService(device));
        }
    }
    public MyLinkedList<Student> getExpelledStudents(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        return SearchService.getStudentsbyState(kardex.getStudents(), Student.State.EXPELLED);
    }
    public MyLinkedList<Student> getScholarshipStudents(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        return SearchService.getStudentsbyState(kardex.getStudents(), Student.State.EXPELLED);
    }
    public MyLinkedList<Student> getAverageStudents(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        return SearchService.getStudentsbyState(kardex.getStudents(), Student.State.AVERAGE);
    }
    public MyLinkedList<Student> getNotifyStudents(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        return SearchService.getStudentsbyState(kardex.getStudents(), Student.State.EXPELLED);
    }
    public boolean importGrades(String kardexId, String subjectId, String pathFile, String nameField, String gradeField){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        Subject subject = SearchService.getSubject(kardex.getCourse(), subjectId);
        MyArrayList<MyHashMap<String, String>> entries = this.dataHandler.read(pathFile);
        if(entries.isEmpty()){
            return false;
        }
        boolean isImportSucess = true;
        for (int i = 0; i < entries.size(); i++) {
            MyHashMap<String, String> entry = entries.get(i);
            String studentName = entry.get(nameField);
            Student student = SearchService.getStudentsbyName(kardex.getStudents(), studentName);
            if(student == null){
                isImportSucess = false;
            }
            double grade = Double.parseDouble(entry.get(gradeField));
            GradesService.addGrade(grade, student, subject);
        }
        return isImportSucess;
    }
    public boolean exportGrades(String kardexId, String pathFile, String studentField, String gradeField){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        MyCircularDoublyLinkedList<Grade> grades = GradesService.computeGrades(kardex);
        MyCircularDoublyLinkedList<Grade> sortedGrades = GradesService.sortGrades(grades);
        MyArrayList<MyHashMap<String, String>> entriesToWrite = gradesToEntries(sortedGrades, studentField, gradeField);
        return dataHandler.write(pathFile, entriesToWrite);
    }
    private MyArrayList<MyHashMap<String, String>> gradesToEntries(MyCircularDoublyLinkedList<Grade> grades, String studentField, String gradeField){
        MyArrayList<MyHashMap<String, String>> entries = new MyArrayList<>();
        for (int i = 0; i < grades.size(); i++) {
            MyHashMap<String, String> entry = new MyHashMap<>();
            entry.put(studentField, grades.get(i).getStudent().getName());
            entry.put(gradeField, String.valueOf(grades.get(i).getFinalGrade()));
            entries.add(entry);
        }
        return entries;
    }
    public MyCircularDoublyLinkedList<Student> getStudents(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        return kardex.getStudents();
    }
    public MyCircularDoublyLinkedList<Subject> getSubjects(String courseId){
        Course course = SearchService.getCourse(this.school, courseId);
        return course.getSubjects();
    }
    public MyCircularDoublyLinkedList<Grade> getGrades(String kardexId){
        Kardex kardex = SearchService.getKardex(this.school, kardexId);
        return GradesService.computeGrades(kardex);
    }
    public Teacher getSubjectTeacher(String subjectId, String courseId){
        Course course = SearchService.getCourse(this.school, courseId);
        Subject subject = SearchService.getSubject(course, subjectId);
        return subject.getTeacher();
    }
    public Teacher getTeacher(String teacherId){
        return SearchService.getTeacher(this.school, teacherId);
    }
    public Student getStudent(String studentId){
        return SearchService.getStudent(this.school, studentId);
    }
}
