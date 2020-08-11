package lunamary.services;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.modelPerson.Director;
import lunamary.model.modelPerson.Parent;
import lunamary.model.modelPerson.Student;
import lunamary.model.modelSchool.Classroom;


public class StudentService {

    public StudentService() {

    }

    public Student createStudent(String name, String lastName, int ci, String gender) {
        Student student = new Student(name, lastName, ci, gender);
        return student;
    }

    public void setParent(Student student, Parent parent) {
        student.addParent(parent);
    }


}
