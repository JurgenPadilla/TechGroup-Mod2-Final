package cachiluis;

// by default the Studens has 4 periods of notes: note of the two months: 1, 2, 3, 4
public class RegisterNotes {
    private String studentId;
    private int[] grades;
    private double average;

    public RegisterNotes(){

    }

    //@deprecated
    public RegisterNotes(String studentId) {
        this.studentId = studentId;
        this.grades = new int[10];
    }

    public void setGrades(int period, int grade) {
        this.grades[period] = grade;
    }

    public void printNotes() {
        for (int note : grades
        ) {
            System.out.println(note);
        }
    }
}
