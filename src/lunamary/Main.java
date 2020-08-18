package lunamary;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import lunamary.model.modelSchool.Classroom;
import lunamary.model.modelSchool.School;
import lunamary.presentation.Menu;
import lunamary.services.SchoolService;

public class Main {
    public static void main(String[] args) {
//        Menu uiSchool = new Menu();
//        uiSchool.menu();


        Menu menu = new Menu();

        SchoolService schoolService = new SchoolService("Edmundo Bojanowski", "Pacata Alta Zona Norte");
        schoolService.registerDirector("Marcelo", "Vargas", 100, "M");

        SchoolService.registerClassroom("1A", "Bottom Junior");
        SchoolService.registerClassroom("2A", "2nd Junior");
        SchoolService.registerClassroom("3A", "3rd Junior");
        menu.viewListClassroom();

        SchoolService.registerTeacher("Maria", "English", 200, "F");
        SchoolService.registerTeacher("Valentina", "Spanish", 201, "F");
        SchoolService.registerTeacher("Jasmine", "Germany", 202, "F");
        menu.viewListTeacher();

        SchoolService.registerSubject("English1", "1A", 200);
        SchoolService.registerSubject("English2", "2A", 200);
        schoolService.registerSubject("English3", "3A", 200);

        schoolService.registerSubject("Spanish1", "1A", 201);
        schoolService.registerSubject("Spanish2", "2A", 201);
        schoolService.registerSubject("Spanish3", "3A", 201);

        schoolService.registerSubject("Germany1", "1A", 202);
        schoolService.registerSubject("Germany2", "2A", 202);
        schoolService.registerSubject("Germany3", "3A", 202);
        menu.viewListSubject();


        schoolService.registerAverageClassroom("1A", 100, 51);
        schoolService.registerAverageClassroom("2A", 100, 51);
        schoolService.registerAverageClassroom("3A", 100, 51);
        menu.viewListClassroomAverage();


        schoolService.registerStudent("1A", "Carla", "Student1A", 500, "M", "momCarla", "Torres", 400, "Celphone", "798512451", "Email", "mom1@gmail.com", "M");
        schoolService.registerStudent("1A", "Carolina", "Student1A", 501, "M", "momCarolina", "Torres", 400, "Celphone", "798512452", "Email", "mom2@gmail.com", "M");
        schoolService.registerStudent("1A", "Carola", "Student1A", 502, "M", "momCalora", "Torres", 400, "Celphone", "798512453", "Email", "mom3@gmail.com", "M");

        schoolService.registerStudent("2A", "Mario", "Student2A", 503, "M", "dadMario", "Torres", 400, "Celphone", "798512454", "Email", "mom4@gmail.com", "M");
        schoolService.registerStudent("2A", "Mauricio", "Student2A", 504, "M", "dadMauricio", "Torres", 400, "Celphone", "798512455", "Email", "mom5@gmail.com", "M");
        schoolService.registerStudent("2A", "Miguel", "Student2A", 505, "M", "dadaMiguel", "Torres", 400, "Celphone", "798512456", "Email", "mom6@gmail.com", "M");

        schoolService.registerStudent("3A", "Teresa", "Student3A", 506, "M", "momTeresa", "Torres", 400, "Celphone", "798512457", "Email", "mom7@gmail.com", "M");
        schoolService.registerStudent("3A", "Tania", "Student3A", 507, "M", "momMarcos", "Torres", 400, "Celphone", "798512458", "Email", "mom8@gmail.com", "M");
        schoolService.registerStudent("3A", "Tono", "Student3A", 508, "M", "momMarcos", "Torres", 400, "Celphone", "798512450", "Email", "mom9@gmail.com", "M");
        menu.viewListStudentsByCourse();


        schoolService.assignGradeStudent("1A", 200, 100, "First Test", 500, "English1", "2020");
        schoolService.assignGradeStudent("1A", 201, 50, "First Test", 500, "Spanish1", "2020");
        schoolService.assignGradeStudent("1A", 202, 60, "First Test", 500, "Germany1", "2020");


        schoolService.assignGradeStudent("1A", 201, 80, "First Test", 501, "Spanish1", "2020");

        schoolService.assignGradeStudent("1A", 202, 100, "First Test", 502, "Germany1", "2020");

        schoolService.assignGradeStudent("2A", 200, 50, "First Test", 503, "English1", "2020");
        schoolService.assignGradeStudent("2A", 201, 100, "First Test", 504, "Spanish2", "2020");
        schoolService.assignGradeStudent("2A", 202, 100, "First Test", 505, "Germany2", "2020");

        schoolService.assignGradeStudent("3A", 200, 60, "First Test", 506, "English1", "2020");
        schoolService.assignGradeStudent("3A", 201, 100, "First Test", 507, "Spanish3", "2020");
        schoolService.assignGradeStudent("3A", 202, 100, "First Test", 508, "Germany3", "2020");


        schoolService.computeAverageStudents("2020");
        menu.viewListKardex();
        menu.viewListKardexHash();
        System.out.printf("******************** AFTER IMPORT ************************************");
        schoolService.importGradeFromFile("src\\lunamary\\resources\\file.json");
        schoolService.computeAverageStudents("2020");
        menu.viewListKardex();
        menu.viewListKardexHash();
//        schoolService.exportDataToFile("src\\lunamary\\resources\\ExportTest1.json", schoolService.getSchool().getKardexHashMap());


    }


}
