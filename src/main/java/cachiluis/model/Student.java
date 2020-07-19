package cachiluis.model;

public class Student extends Person {
    private Tutor tutor;
    private String id;
    private String name;

    public Student(String id, String studentName) {
        this.id = id;
        this.name = studentName;
    }
    public void setTutor(Tutor tutor){
        this.tutor = tutor;
    }

    public String getId() {
        return id;
    }
}
