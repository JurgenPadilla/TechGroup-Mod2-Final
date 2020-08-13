package lunamary.services;

import lunamary.model.modelPerson.Parent;


public class ParentService {

    public ParentService() {

    }

    public Parent createParent(String name, String lastname, int ci, String gender) {
        Parent parent = new Parent(name, lastname, ci, gender);
        return parent;
    }


}
