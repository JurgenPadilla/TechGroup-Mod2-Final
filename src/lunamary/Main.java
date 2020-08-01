package lunamary;

import lunamary.modelPerson.*;
import lunamary.modelSchool.*;
import lunamary.services.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        while (!salir) {
            System.out.println("1. Register New School");
            System.out.println("2. Register New Classroom");
            System.out.println("3. Register New Subject");
            System.out.println("4. Register Student");
            System.out.println("5. Register Director");
            System.out.println("6. Register Teacher");
            System.out.println("7. Director set Average by Course");
            System.out.println("8. Teacher add Grade Student");
            System.out.println("9. Teacher Import Grade");
            System.out.println("10. Director generate General Report");
            System.out.println("11. Director generate General Report");


            try {

                System.out.println("Write Option");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 12:
                        salir = true;
                        break;
                    default:
                        System.out.println("Tried again");
                }
            } catch (InputMismatchException e) {
                System.out.println("Should be enter number");
                sn.next();
            }
        }


        Device device1 = new Device("Celular", "77559048");
        List<Device> deviceList = new ArrayList<>();
        deviceList.add(device1);

        Parent parent = new Parent("papa", "papa", 20, deviceList);

        Student student = new Student("Mary", "Luna", 34, deviceList, parent);
        String res = student.getName();
        System.out.println("Student: " + res);
        Director director = new Director("director", "director", 56, deviceList);
        String res1 = director.getName();
        System.out.println("Director: " + res1);
        Teacher teacher = new Teacher("director", "director", 56, deviceList);
        String res2 = teacher.getName();
        System.out.println("Teacher: " + res2);

        Subject subject1 = new Subject(teacher, "Materia1");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);


        Classroom classroom = new Classroom(subjectList, "Curso1A", studentList);

        List<Classroom> classroomList = new ArrayList<>();
        classroomList.add(classroom);

        Grade grade = new Grade();
        List<Grade> gradeList = new ArrayList<>();
        GradeStudent gradeStudent = new GradeStudent(gradeList, student, "2020");
        List<GradeStudent> gradeStudentList = new ArrayList<>();


        School school = new School("Escueka1", director, classroomList, gradeStudentList);
        school.getName();


        DirectorService directorService = new DirectorService(director);
        directorService.assignAverage(classroomList, "01-01-2020", 50, 100, "Classroom1");
        System.out.println(" aplazados: " + classroom.getMinimumAverageApprobation());
        System.out.println("Becado: " + classroom.getAverageScholarshipGrade());

        TeacherService teacherService = new TeacherService(teacher);
        teacherService.assignAverageStudent(40, student, subject1, "2020");


        grade.setGrade(10);
        grade.setDescription("primer trimestre");

        GradeService gradeService = new GradeService();
        gradeService.validateGrade(grade.getGrade());


        List<IObserver> observers = new ArrayList<>();


        NotificationService notificationService = new NotificationService();
//        gradeService.joinObserver(notificationService);


    }


}
