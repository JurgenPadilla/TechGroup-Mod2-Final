package colinajose.model.people;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;

public class Student extends Person {
    public enum State {SCHOLARSHIP, EXPELLED, NOTIFY, AVERAGE};
    private State state;
    private float gradeAverage;
    private MyCircularDoublyLinkedList<Parent> parents;

    public Student(String name, String CI, int age, String gender, Contact contact) {
        super(name, CI, age, gender, contact);
        this.parents = new MyCircularDoublyLinkedList<>();
    }

    public Student(String name, String CI, int age, String gender) {
        super(name, CI, age, gender);
        this.parents = new MyCircularDoublyLinkedList<>();
    }

    public String getState() {
        return state.toString();
    }

    public void setState(String state) {
        this.state = State.valueOf(state);
    }

    public float getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(float gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public void addParent(Parent parent){
        this.parents.add(parent);
    }

    public void removeParent(Parent parent){
        this.parents.remove(parent);
    }

    public MyCircularDoublyLinkedList getParents(){
        return this.parents;
    }

    public void setParents(MyCircularDoublyLinkedList parents){
        this.parents = parents;
    }

}
