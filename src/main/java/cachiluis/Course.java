package cachiluis;

import datastructures.arraylist.MyArrayList;

public class Course {
    private String curseName;
    private MyArrayList<Kardex> kardexStudents;

    public Course(String curseName) {
        this.curseName = curseName;
        kardexStudents = new MyArrayList<>();
    }

    @Override
    public String toString() {
        return curseName;
    }

    // Kardex id is the same than the student ID
    public Kardex getStudentKardex(String KardexId, String studentName) {
        for (int i = 0; i < kardexStudents.size(); i++) {
            Kardex index = kardexStudents.get(i);
            if (index.getId() == KardexId) {
                return index;
            }
        }
        Kardex newKardex = new Kardex(KardexId, studentName);
        this.kardexStudents.add(newKardex);
        return newKardex;
    }

    // Kardex id is the same than the student ID
    public Kardex getStudentKardex(String KardexId) {
        for (int i = 0; i < kardexStudents.size(); i++) {
            Kardex index = kardexStudents.get(i);
            if (index.getId() == KardexId) {
                return index;
            }
        }
        return null;
    }

    public void setNote(String studentId, String subject, int period, int grade) {
        Kardex currentKardex = this.getStudentKardex(studentId);
        if (currentKardex != null) {
         currentKardex.setGradesForSubject(subject,period,grade);
        }
    }
}
