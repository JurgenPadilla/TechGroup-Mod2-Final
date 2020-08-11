package lunamary.model.modelPerson;

import lunamary.model.BaseModel;

public abstract class AbstractPerson extends BaseModel {

    private String name;
    private String lastName;
    private int ci;
    private String gender;


    public AbstractPerson(String name, String lastName, int age, String gender) {
        this.name = name;
        this.lastName = lastName;
        this.ci = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
