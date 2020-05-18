package cachiluis;

public class Student extends Person {
    private Parent parent;
    private String id;
    private String name;

    public Student(String id, String studentName) {
        this.id = id;
        this.name = studentName;
    }
    public void setParent(Parent parent){
        this.parent = parent;
    }

    public String getId() {
        return id;
    }
}
