package cachiluis.model;

import datastructures.arraylist.MyArrayList;

public class Subject {

    private Teacher teacher;
    private String subjectName;
    private MyArrayList<Kardex> subjectKardexes;

    public Subject(String subjectName, Teacher teacher) {
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.subjectKardexes = new MyArrayList<>();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Kardex getKardex(String kardexId) {
        for (int i = 0; i < subjectKardexes.size(); i++) {
            Kardex index = subjectKardexes.get(i);
            if (index.toString() == kardexId) {
                return index;
            }
        }
        return null;
    }

    public void setKardex(Kardex kardex) {
        this.subjectKardexes.add(kardex);
    }

    @Override
    public String toString() {
        return subjectName;
    }

}
