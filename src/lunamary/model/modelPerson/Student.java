package lunamary.model.modelPerson;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.modelSchool.GradeStudent;


public class Student extends AbstractPerson {
    private String status;

    private MyCircularDoublyLinkedList<Parent> parentList;


    public Student(String name, String lastName, int ci, String gender) {
        super(name, lastName, ci, gender);
        this.parentList = new MyCircularDoublyLinkedList<>();

    }

    public MyCircularDoublyLinkedList<Parent> getParents() {
        return parentList;
    }

    public void setParents(MyCircularDoublyLinkedList<Parent> parents) {
        this.parentList = parents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addParent(Parent parent) {
        this.parentList.add(parent);
    }
}
