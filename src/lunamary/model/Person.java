package lunamary.model;

public class Person {

    private String name;
    private String lastname;
    private int age;

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastname = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
