package lunamary.modelPerson;
import java.util.List;

public class Person {

    private String name;
    private String lastname;
    private int age;
    private List<Device> deviceList;


    public Person(String name, String lastName, int age, List<Device> deviceList) {
        this.name = name;
        this.lastname = lastName;
        this.age = age;
        this.deviceList = deviceList;
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

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

}
