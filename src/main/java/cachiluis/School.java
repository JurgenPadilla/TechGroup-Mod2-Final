package cachiluis;

import datastructures.arraylist.MyArrayList;

public class School {
    private String name;
    private static School school;
    private MyArrayList<Course> courses;

    private School(String name){
        this.name = name;
        courses = new MyArrayList<>();
    }

    public Course getCurse(String curseName, int year) {
        //year as another param
        for (int i = 0; i < courses.size() ; i++) {
            Course index = courses.get(i);
            if (index.toString() == curseName) {
                return index;
            }
        }
        Course newCurse = new Course(curseName);
        this.courses.add(newCurse);
        return newCurse;
    }

    public static School getSchool(){
        if (school == null){
            school = new School("my School");
        }
        return school;
    }
}
