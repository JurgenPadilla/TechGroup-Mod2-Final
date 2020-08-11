package lunamary.services;

import lunamary.model.modelPerson.Device;
import lunamary.model.modelPerson.Parent;
import lunamary.model.modelPerson.Student;


public class ParentService {

    public ParentService() {

    }

    public Parent createParent(String name, String lastname, int ci) {
        Parent parent = new Parent(name, lastname, ci);
        return parent;
    }


}
