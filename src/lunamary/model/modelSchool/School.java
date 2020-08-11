package lunamary.model.modelSchool;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.BaseModel;
import lunamary.model.modelPerson.Device;
import lunamary.model.modelPerson.Director;
import lunamary.model.modelPerson.Parent;
import lunamary.model.modelPerson.Teacher;

public class School extends BaseModel {

    private String name;
    private String address;
    private Director director;

    private MyCircularDoublyLinkedList<Teacher> teacherList;
    private MyCircularDoublyLinkedList<Classroom> classroomList;
    private MyCircularDoublyLinkedList<Parent> parentList;
    private MyCircularDoublyLinkedList<Device> deviceList;
    private MyCircularDoublyLinkedList<GradeStudent> gradeStudentList;


    public School() {
        this.teacherList = new MyCircularDoublyLinkedList<>();
        this.classroomList = new MyCircularDoublyLinkedList<>();
        this.gradeStudentList = new MyCircularDoublyLinkedList<>();

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

    public MyCircularDoublyLinkedList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(MyCircularDoublyLinkedList<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public MyCircularDoublyLinkedList<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(MyCircularDoublyLinkedList<Classroom> classroomList) {
        this.classroomList = classroomList;
    }

    public MyCircularDoublyLinkedList<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(MyCircularDoublyLinkedList<Parent> parentList) {
        this.parentList = parentList;
    }

    public MyCircularDoublyLinkedList<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(MyCircularDoublyLinkedList<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public MyCircularDoublyLinkedList<GradeStudent> getGradeStudentList() {
        return gradeStudentList;
    }

    public void setGradeStudentList(MyCircularDoublyLinkedList<GradeStudent> gradeStudentList) {
        this.gradeStudentList = gradeStudentList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addTeacher(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void addClassroom(Classroom classroom) {
        this.classroomList.add(classroom);
    }

    public void addParent(Parent parent) {
        this.parentList.add(parent);
    }

    public void addDevice(Device device) {
        this.deviceList.add(device);
    }

    public void addGradeStudent(GradeStudent gradeStudent) {
        this.gradeStudentList.add(gradeStudent);
    }

}
