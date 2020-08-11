package lunamary.services;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.modelPerson.Parent;
import lunamary.model.modelPerson.Student;
import lunamary.model.modelPerson.Teacher;
import lunamary.model.modelSchool.Classroom;
import lunamary.model.modelSchool.Subject;

public class SearchService {


    public static Classroom getClassroom(String codeClassroom) {
        Classroom classroom = null;
        MyCircularDoublyLinkedList<Classroom> elements = SchoolService.getSchool().getClassroomList();

        for (int i = 0; i < elements.size(); i++) {
            Classroom element = elements.get(i);
            if (element.getCode().equals(codeClassroom)) {
                classroom = element;
            }

        }
        return classroom;
    }

    public static Teacher getTeacher(int ciTeacher) {
        Teacher teacher = null;
        MyCircularDoublyLinkedList<Teacher> elements = SchoolService.getSchool().getTeacherList();
        for (int i = 0; i < elements.size(); i++) {
            Teacher element = elements.get(i);
            if (element.getCi() == (ciTeacher)) {
                teacher = element;
            }

        }
        return teacher;
    }

    public static Parent getParent(int ciParent) {
        Parent parent = null;
        MyCircularDoublyLinkedList<Parent> elements = SchoolService.getSchool().getParentList();
        for (int i = 0; i < elements.size(); i++) {
            Parent element = elements.get(i);
            if (element.getCi() == (ciParent)) {
                parent = element;
            }

        }
        return parent;
    }


    public static Student getStudent(Classroom classroom, int ciStudent) {
        Student student = null;
        MyCircularDoublyLinkedList<Student> elements = classroom.getStudentList();
        for (int i = 0; i < elements.size(); i++) {
            Student element = elements.get(i);
            if (element.getCi() == (ciStudent)) {
                student = element;
            }

        }
        return student;
    }

    public static Subject getSubject(Classroom classroom, String nameSubject) {
        Subject subject = null;
        MyCircularDoublyLinkedList<Subject> elements = classroom.getSubjectList();
        for (int i = 0; i < elements.size(); i++) {
            Subject element = elements.get(i);
            if (element.getName() == (nameSubject)) {
                subject = element;
            }

        }
        return subject;
    }

}