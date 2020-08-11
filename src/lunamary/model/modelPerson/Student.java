package lunamary.model.modelPerson;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.modelSchool.GradeStudent;


public class Student extends AbstractPerson {
    public enum Value {SCHOLARSHIP, EXPELLED, APPROVED, ACTIVE}

    ;
    private Value status;
    private MyCircularDoublyLinkedList<Parent> parentList;


    public Student(String name, String lastName, int ci, String gender) {
        super(name, lastName, ci, gender);
        this.parentList = new MyCircularDoublyLinkedList<>();
        this.status = Value.ACTIVE;
    }

    public MyCircularDoublyLinkedList<Parent> getParents() {
        return parentList;
    }

    public void setParents(MyCircularDoublyLinkedList<Parent> parents) {
        this.parentList = parents;
    }

    public Value getStatus() {
        return status;
    }

    public void setStatus(Value status) {
        this.status = status;
    }

    public void addParent(Parent parent) {
        this.parentList.add(parent);
    }
}
