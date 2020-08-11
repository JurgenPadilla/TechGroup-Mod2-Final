package lunamary.model.modelPerson;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;

import javax.security.auth.Subject;

public class Teacher extends AbstractPerson {

    private MyCircularDoublyLinkedList<Subject> subjects;

    public Teacher(String name, String lastName, int age, String gender) {
        super(name, lastName, age, gender);

    }

    public MyCircularDoublyLinkedList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(MyCircularDoublyLinkedList<Subject> subjects) {
        this.subjects = subjects;
    }

}
