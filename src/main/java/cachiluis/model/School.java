package cachiluis.model;

import datastructures.arraylist.MyArrayList;

public class School {
    private String name;
    private static School school;
    private MyArrayList<Course> courses;
    private MyArrayList<Student> students;
    private MyArrayList<Teacher> teachers;

    private School(String name) {
        this.name = name;
        courses = new MyArrayList<>();
    }

    public static School getSchool() {
        if (school == null) {
            school = new School("my School");
        }
        return school;
    }

    public Course getCurse(String curseName) {
        for (int i = 0; i < courses.size(); i++) {
            Course index = courses.get(i);
            if (index.toString() == curseName) {
                return index;
            }
        }
        return null;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public Student getStudent(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            Student index = students.get(i);
            if (index.toString() == studentId) {
                return index;
            }
        }
        return null;
    }

    public void setStudents(Student student) {
        this.students.add(student);
    }

    public Teacher getTeacher(String teacherId) {
        for (int i = 0; i < teachers.size(); i++) {
            Teacher index = teachers.get(i);
            if (index.toString() == teacherId) {
                return index;
            }
        }
        return null;
    }

    public void setTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

}
