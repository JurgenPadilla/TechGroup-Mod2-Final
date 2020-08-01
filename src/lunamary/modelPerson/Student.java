package lunamary.modelPerson;

import java.util.List;

public class Student extends Person {
    private Parent parent;


    public Student(String name, String lastName, int age, List<Device> deviceList, Parent parent) {
        super(name, lastName, age, deviceList);
        this.parent = parent;

    }

}
