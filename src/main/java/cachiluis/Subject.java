package cachiluis;

public class Subject {
    private Professor profesor;
    private String subjectName;
    private RegisterNotes grades;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        grades = new RegisterNotes();
    }

    public void registerGrades(int period, int grade){
        grades.setGrades(period, grade);
    }

    @Override
    public String toString() {
        return subjectName;
    }
}
