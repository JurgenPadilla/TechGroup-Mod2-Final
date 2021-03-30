package lunamary.presentation;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.*;
import lunamary.model.modelSchool.Classroom;
import lunamary.model.modelSchool.Subject;
import lunamary.services.SchoolService;

import java.util.Map;
import java.util.Scanner;

public class Menu {
    //    SchoolService schoolService = new SchoolService();
    SchoolService schoolService;
    Scanner scanner = new Scanner(System.in);
    String selectOption = "";
    String dataSchool = "";

    public void menu() {

        if (selectOption.contains("1") == false) {
            uiRegisterNewSchool();
        }
        if (selectOption.contains("2") == false) {
            uiRegisterDirectorSchool();
        }

        boolean option = true;
        do {
            System.out.println("#################################################");
            System.out.println("Creation sequence for the school system:");
            System.out.println("#################################################");
//            if (selectOption.contains("1") == false){System.out.println("\t 1. Register New School");}
//            if (selectOption.contains("2") == false){System.out.println("\t 2. Assign Director to the school");}
            if (selectOption.contains("3") == false) {
                System.out.println("\t 3. Register New Classroom ");
            } else {
                System.out.println("\t 3. Register New Classroom   (*)");
            }
            if (selectOption.contains("4") == false) {
                System.out.println("\t 4. Register New Teacher");
            } else {
                System.out.println("\t 4.  Register New Teacher  (*)");
            }
            ;
            if (selectOption.contains("5") == false) {
                System.out.println("\t 5. Register New Subject");
            } else {
                System.out.println("\t 5. Register New Subject  (*)");
            }
            ;
            if (selectOption.contains("6") == false) {
                System.out.println("\t 6. Director set Average by classroom");
            } else {
                System.out.println("\t 6. Director set Average by classroom  (*)");
            }
            ;
            if (selectOption.contains("7") == false) {
                System.out.println("\t 7. Register Student");
            } else {
                System.out.println("\t 7. Register Student   (*)");
            }
            ;
            if (selectOption.contains("8") == false) {
                System.out.println("\t 8. Register Assign Grade Student");
            } else {
                System.out.println("\t 8. Register Assign Grade Student   (*)");
            }
            if (selectOption.contains("9") == false) {
                System.out.println("\t 9. Director generate General Report");
            } else {
                System.out.println("\t 9. Director generate General Report    (*)");
            }
            System.out.println("\t Para salir ingrese 's'. ");
            System.out.println("-------------------------------------------------");
            System.out.print("Seleccione una opcion: ");
            String selectOption = scanner.nextLine();
            System.out.println("#################################################\n\n");

            switch (selectOption.toLowerCase()) {
                case "3":
                    uiRegisterClassRoom();
                    option = false;
                    break;
                case "4":
                    uiRegisterTeacher();
                    option = false;
                    break;
                case "5":
                    uiRegisterSubject();
                    option = false;
                    break;
                case "6":
                    uiRegisterAverageClassroom();
                    option = false;
                    break;
                case "7":
                    uiRegisterStudent();
                    option = false;
                    break;
                case "8":
                    uiRegisterAssignGradeStudent();
                    option = false;
                    break;
                case "9":
                    viewReport();
                    option = false;
                    break;
                case "s":
                    option = false;
                    break;
                default:
                    menu();
                    break;
            }
            // if (selectOption.contains("5") == false){System.out.println("\t 5. Register New Subject");}else{System.out.println("\t 5. Register New Subject   (*)");};
        } while (option);
    }

    public void viewReport() {
        System.out.print("\t Insert  year: ");
        String year = scanner.nextLine();
        schoolService.computeAverageStudents(year);
        viewListKardexHash();
        schoolService.notifyDevices();
        viewNotifications();
    }

    public void uiRegisterNewSchool() {
        System.out.println("=================================================");
        System.out.println("1. Register New School");
        System.out.println("=================================================");
        System.out.print("\t Insert  name school: ");
        String nameSchool = scanner.nextLine();
        System.out.print("\t Insert the address school: ");
        String address = scanner.nextLine();
        System.out.println("=================================================\n");
        stepNewSchool(nameSchool, address);
        selectOption += selectOption + "1";
        dataSchool = "School: " + nameSchool;
        menu();
    }


    public void stepNewSchool(String nameSchool, String address) {
        schoolService = new SchoolService(nameSchool, address);

    }

    public void uiRegisterDirectorSchool() {
        System.out.println("=================================================");
        System.out.println(" 2. Assign director to the school ");
        System.out.println("=================================================");
        System.out.print("\t Insert  name Director: ");
        String director = scanner.nextLine();
        System.out.print("\t Insert the last name Director: ");
        String lastName = scanner.nextLine();
        System.out.print("\t Insert the last CI Director: ");
        String ci = scanner.nextLine();
        System.out.print("\t Insert the Gender Director: ");
        String gender = scanner.nextLine();
        schoolService.registerDirector(director, lastName, Integer.parseInt(ci), gender);
        System.out.println("=================================================\n");
        schoolService.registerDirector(director, lastName, Integer.parseInt(ci), gender);
        selectOption += "2";
        dataSchool += ", Director: " + director + " " + lastName;
        menu();
    }

    public void uiRegisterClassRoom() {
        System.out.println("==============================================================");
        System.out.println(dataSchool.toUpperCase());
        System.out.println("             3. Register New Classroom");
        System.out.println("==============================================================");
        viewListClassroom();
        schoolService.getSchool().getClassroomList();
        System.out.print("\t Insert the room acronym: ");
        String id = scanner.nextLine();
        System.out.print("\t Insert the room name: ");
        String name = scanner.nextLine();
        SchoolService.registerClassroom(id, name);
        System.out.println("==============================================================\n");
        selectOption += "3";
        menu();
    }

    public void viewListClassroom() {
        MyCircularDoublyLinkedList list = schoolService.getSchool().getClassroomList();
        if (list.size() > 0) {
            System.out.println("    List Classroom:");
            for (int i = 0; i < list.size(); i++) {
                Classroom room = (Classroom) list.get(i);
                String name = room.getCode() + " - " + room.getName();
                System.out.println("    • " + name);
            }
            System.out.println();
        }
    }

    public void uiRegisterTeacher() {
        System.out.println("=================================================");
        System.out.println("4. Register Teacher");
        System.out.println("=================================================");
        viewListTeacher();
        System.out.print("\t Insert the name Teacher: ");
        String nameTeacher = scanner.nextLine();
        System.out.print("\t Insert the last name Teacher: ");
        String lastName = scanner.nextLine();
        System.out.print("\t Insert the Ci Teacher: ");
        String ciTeacher = scanner.nextLine();
        System.out.print("\t Insert the Gender: ");
        String gender = scanner.nextLine();
        SchoolService.registerTeacher(nameTeacher, lastName, Integer.parseInt(ciTeacher), gender);
        System.out.println("================================================= \n");
        selectOption += "4";
        menu();
    }

    public void viewListTeacher() {
        MyCircularDoublyLinkedList list = schoolService.getSchool().getTeacherList();
        if (list.size() > 0) {
            System.out.println("    List Teachers:");
            for (int i = 0; i < list.size(); i++) {
                Teacher teacher = (Teacher) list.get(i);
                String name = teacher.getName() + " " + teacher.getLastname() + " (" + teacher.getCi() + ")";
                ;
                System.out.println("    • " + name);
            }
            System.out.println();
        }
    }

    public void uiRegisterSubject() {
        System.out.println("=================================================");
        System.out.println("5. Register Subject");
        System.out.println("=================================================");
        viewListSubject();
        System.out.print("\t Insert the name Subject: ");
        String nameSubject = scanner.nextLine();
        System.out.print("\t Insert the code classroom: ");
        String codeClassroom = scanner.nextLine();

        System.out.print("\t Insert the Ci Teacher: ");
        String ciTeacher = scanner.nextLine();
        SchoolService.registerSubject(nameSubject, codeClassroom, Integer.parseInt(ciTeacher));
        System.out.println("================================================= \n");
        selectOption += "5";
        menu();
    }

    public void viewListSubject() {
        MyCircularDoublyLinkedList list = schoolService.getSchool().getClassroomList();
        if (list.size() > 0) {
            System.out.println("                 List Subject       ");
            System.out.println("    ClassRoom       |       Subject      |       teacher      ");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            for (int i = 0; i < list.size(); i++) {
                Classroom classroom = (Classroom) list.get(i);
                MyCircularDoublyLinkedList listSubject = classroom.getSubjectList();
                for (int j = 0; j < listSubject.size(); j++) {
                    Subject subject = (Subject) listSubject.get(j);
                    String col1 = classroom.getCode() + " " + classroom.getName();
                    String col2 = subject.getName();
                    String col3 = subject.getTeacher().getName() + " " + subject.getTeacher().getLastname() + " (" + subject.getTeacher().getCi() + ")";
//                    System.out.println(classroom.getCode() + "          " + classroom.getName() + "         " + subject.getName() + "            " +
//                            subject.getTeacher().getName() + " " + subject.getTeacher().getLastname()+" ("+subject.getTeacher().getCi()+")");

                    System.out.println(createRowData(col1, col2, col3));
                }
//            String name = teacher.getName()+" "+teacher.getLastname();
//            System.out.println("    • "+ name);
            }
            System.out.println();
        }
    }

    public String createRowData(String col1, String col2, String col3) {
        String row = "";
        String[] cols = {col1, col2, col3};
        String newCol = "";
        for (String col : cols) {
            int letter = col.length();
            while (letter < 19) {
                col += " ";
                letter++;
            }
            row += " " + col + "|";
        }
        return row;
    }

    public void uiRegisterAverageClassroom() {
        System.out.println("=================================================");
        System.out.println("6. Register Average Classroom");
        System.out.println("=================================================");
        System.out.print("\t Insert the name Classroom: ");
        String nameClassroom = scanner.nextLine();
        System.out.print("\t Insert scholarship average: ");
        String average = scanner.nextLine();
        System.out.print("\t Insert minimum approbation Average : ");
        String averageMinApproval = scanner.nextLine();
        System.out.print("\t Insert limit expelled average: ");
        String averageExpelled = scanner.nextLine();
        schoolService.registerAverageClassroom(nameClassroom, Integer.parseInt(average), Integer.parseInt(averageMinApproval), Integer.parseInt(averageExpelled));
        System.out.println("================================================= \n");
        selectOption += "6";
        menu();
    }

    public void uiRegisterStudent() {
        System.out.println("=================================================");
        System.out.println("7. Register Student");
        System.out.println("=================================================");
        System.out.print("\t Insert the name Classroom: ");
        String nameClassroom = scanner.nextLine();
        System.out.print("\t Insert the name Student: ");
        String nameStudent = scanner.nextLine();
        System.out.print("\t Insert the last name Student: ");
        String lastNameStudent = scanner.nextLine();
        System.out.print("\t Insert the CI Student: ");
        String ciStudent = scanner.nextLine();
        System.out.print("\t Insert Student gender: ");
        String gender = scanner.nextLine();
        System.out.print("\t Insert the name Parent: ");
        String nameParent = scanner.nextLine();
        System.out.print("\t Insert the last name Parent: ");
        String lastNameParent = scanner.nextLine();
        System.out.print("\t Insert the CI Parent: ");
        String ciParent = scanner.nextLine();
        System.out.print("\t Insert the type Device: ");
        String typeDevice = scanner.nextLine();
        System.out.print("\t Insert the number Device: ");
        String numberDevice = scanner.nextLine();
        System.out.print("\t Insert the E-mail: ");
        String email = scanner.nextLine();
        System.out.print("\t Insert Parent gender: ");
        String genderParent = scanner.nextLine();
        schoolService.registerStudent(nameClassroom, nameStudent, lastNameStudent, Integer.parseInt(ciStudent), gender, nameParent, lastNameParent, Integer.parseInt(ciParent), typeDevice, numberDevice, "Email", email, genderParent);
        System.out.println("================================================= \n");
        selectOption += "7";
        menu();
    }

    public void uiRegisterAssignGradeStudent() {
        System.out.println("=================================================");
        System.out.println("8. Register Assign Grade Student");
        System.out.println("=================================================");
        System.out.print("\t Insert the name Classroom: ");
        String nameClassroom = scanner.nextLine();
        System.out.print("\t Insert the CI teacher: ");
        String ciTeacher = scanner.nextLine();
        System.out.print("\t Insert the grade: ");
        String grade = scanner.nextLine();
        System.out.print("\t Insert the description: ");
        String description = scanner.nextLine();
        System.out.print("\t Insert the ci student: ");
        String ciStudent = scanner.nextLine();
        System.out.print("\t Insert the name Subject: ");
        String subject = scanner.nextLine();
        System.out.print("\t Insert the Year: ");
        String year = scanner.nextLine();
        schoolService.assignGradeStudent(nameClassroom, Integer.parseInt(ciTeacher), Integer.parseInt(grade), description, Integer.parseInt(ciStudent), subject, year);
        System.out.println("================================================= \n");
        selectOption += "8";
        menu();
    }

    public void uiImportFileJson() {
        System.out.println("==============================================================");
        System.out.println(dataSchool.toUpperCase());
        System.out.println("             9. Import Grade file Json");
        System.out.println("==============================================================");
        System.out.print("\t Insert the path file Json: ");
        String pathFile = scanner.nextLine();
        System.out.println("==============================================================");
        selectOption += "9";
        menu();
    }

    public boolean verifyPathFile(String path) {
        boolean pathVoid = false;
        if (path != "") {
            schoolService.importGradeFromFile(path);
            pathVoid = true;
        }
        return pathVoid;
    }


    public void viewListClassroomAverage() {
        MyCircularDoublyLinkedList list = schoolService.getSchool().getClassroomList();
        if (list.size() > 0) {
            System.out.println("    List Classroom:");
            for (int i = 0; i < list.size(); i++) {
                Classroom room = (Classroom) list.get(i);
                String name = room.getCode() + " - " + room.getName() + " - " + room.getAverageScholarshipGrade() + "-" + room.getMinimumAverageApprobation();
                System.out.println("    • " + name);
            }
            System.out.println();
        }
    }


    public void viewListStudentsByCourse() {
        MyCircularDoublyLinkedList list = schoolService.getSchool().getClassroomList();
        if (list.size() > 0) {
            System.out.println("    List Classroom:");
            for (int i = 0; i < list.size(); i++) {
                Classroom room = (Classroom) list.get(i);
                String name = room.getCode() + " - " + room.getName() + " - " + room.getAverageScholarshipGrade() + "-" + room.getMinimumAverageApprobation();
                System.out.println("    • " + name);
                MyCircularDoublyLinkedList listStudents = room.getStudentList();
                if (listStudents.size() > 0) {
                    System.out.println("    List Students:");
                    for (int j = 0; j < listStudents.size(); j++) {
                        Student student = (Student) listStudents.get(j);
                        String fullName = student.getName() + " " + student.getLastname() + " " + student.getCi();
                        System.out.println("    • " + fullName);


                    }
                }
                System.out.println();
            }
        }

    }


    public void viewListKardex() {
        MyCircularDoublyLinkedList list = schoolService.getSchool().getKardexList();
        if (list.size() > 0) {
            System.out.println("   List Kardex: **** NO SORT******");
            for (int i = 0; i < list.size(); i++) {
                Kardex kardex = (Kardex) list.get(i);
                String name = kardex.getStudent().getName() + " - " + kardex.getClassroom().getCode() + " - " + kardex.getFinalAverage();
                System.out.println("    • " + name);
                System.out.println();
            }
        }

    }

    public void viewListKardexHash() {
        Map<String, MyLinkedList<Kardex>> listHash = schoolService.getSchool().getKardexHashMap();
        if (listHash.size() > 0) {
            String rows = "      Classroom     |       Student      |       Averange     \n";
            rows += "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n";
            System.out.println("    List sort Kardex by Classroom :");
            for (Map.Entry<String, MyLinkedList<Kardex>> listHashlist : listHash.entrySet()) {
//                System.out.println(listHashlist.getKey() + ": ");
                for (int i = 0; i < listHashlist.getValue().size(); i++) {
                    Kardex kardex = (Kardex) listHashlist.getValue().get(i);
                    String name = kardex.getStudent().getName();
//                    System.out.println("    • " + name);
                    rows += createRow(new String[]{kardex.getClassroom().getCode(), name + " " + kardex.getStudent().getLastname(), kardex.getFinalAverage() + ""}, 19) + "\n";
//                    System.out.println();
                }
                rows += "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n";

            }
            System.out.println(rows);

        }

    }

    public void viewDataSchool() {
        System.out.println("=================================================");
        System.out.println("School: " + this.schoolService.getSchool().getName());
        System.out.print("Director: " + this.schoolService.getSchool().getDirector().getName());
        System.out.print(" " + this.schoolService.getSchool().getDirector().getLastname());
        System.out.println(" -  C.I.: " + this.schoolService.getSchool().getDirector().getName());
        System.out.println("=================================================");
    }

    public String createRow(String[] data, int sizeCol) {
        String row = "";
        String[] cols = data;
        String newCol = "";
        for (String col : cols) {
            int letter = col.length();
            while (letter < sizeCol) {
                col += " ";
                letter++;
            }
            row += " " + col + "|";
        }
        return row;
    }


    public void viewNotifications() {
        MyCircularDoublyLinkedList<Parent> parentList = schoolService.getSchool().getParentList();
        String rows = "          Device           |            Message           |            Parent          \n";
        rows += "¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n";
        for (int i = 0; i < parentList.size(); i++) {
            Parent parent = parentList.get(i);
            rows += createRow(new String[]{parent.getDevice().getType(), parent.getDevice().getTemplateMsj(), parent.getName() + " " + parent.getLastname() + ""}, 29) + "\n";
        }
        System.out.println(rows);
    }

    public void menuTest() {

        schoolService = new SchoolService("UNIDAD EDUCATIVA EDMUNDO BOJANOWSKI", "PACATA ALTA - ZONA NORTE");
        this.schoolService.getSchool().getName();
        schoolService.registerDirector("Marcelo", "Vargas", 1000, "M");
        this.viewDataSchool();


        schoolService.registerClassroom("1A", "PRIMERO DE PRIMARIA");
        schoolService.registerClassroom("2A", "SEGUNDO DE PRIMARIA");
        schoolService.registerClassroom("3A", "TERCERO DE PRIMARIA");
        schoolService.registerClassroom("4A", "CUARTO DE PRIMARIA ");
        viewListClassroom();

        schoolService.registerTeacher("Maria", "Spanish", 200, "F");
        schoolService.registerTeacher("Valentina", "English", 201, "F");
        schoolService.registerTeacher("Jasmine", "German", 202, "F");
        schoolService.registerTeacher("Cecila", "French", 203, "F");
        viewListTeacher();

        schoolService.registerSubject("Spanish-1", "1A", 200);
        schoolService.registerSubject("Spanish-2", "2A", 200);
        schoolService.registerSubject("Spanish-3", "3A", 200);
        schoolService.registerSubject("Spanish-4", "4A", 200);

        schoolService.registerSubject("English-1", "1A", 201);
        schoolService.registerSubject("English-2", "2A", 201);
        schoolService.registerSubject("English-3", "3A", 201);
        schoolService.registerSubject("English-4", "4A", 201);


        schoolService.registerSubject("German-1", "1A", 202);
        schoolService.registerSubject("German-2", "2A", 202);
        schoolService.registerSubject("German-3", "3A", 202);
        schoolService.registerSubject("German-4", "4A", 202);


        schoolService.registerSubject("French-1", "1A", 203);
        schoolService.registerSubject("French-2", "2A", 203);
        schoolService.registerSubject("French-3", "3A", 203);
        schoolService.registerSubject("French-4", "4A", 203);

        viewListSubject();


        schoolService.registerAverageClassroom("1A", 100, 51, 20);
        schoolService.registerAverageClassroom("2A", 100, 51, 20);
        schoolService.registerAverageClassroom("3A", 100, 51, 20);
        schoolService.registerAverageClassroom("4A", 100, 51, 20);

        viewListClassroomAverage();


        schoolService.registerStudent("1A", "Carla", "Student1A", 500, "F", "momCarla", "Torres", 400, "Celphone", "798512451", "Email", "mom1@gmail.com", "M");
        schoolService.registerStudent("1A", "Jorge", "Student1A", 501, "M", "momJorge", "Gutierres", 401, "Celphone", "798512452", "Email", "mom2@gmail.com", "M");
        schoolService.registerStudent("1A", "Mario", "Student1A", 502, "M", "momMario", "Sanchez", 402, "Celphone", "798512453", "Email", "mom2@gmail.com", "M");
        schoolService.registerStudent("1A", "Carolina", "Student1A", 503, "F", "momCarolina", "Rdrigues", 403, "Celphone", "798512454", "Email", "mom2@gmail.com", "M");
        schoolService.registerStudent("1A", "Pedro", "Student1A", 504, "M", "momPedro", "Zurita", 404, "Celphone", "798512455", "Email", "mom3@gmail.com", "M");

        schoolService.registerStudent("2A", "Mauricio", "Student2A", 505, "M", "dadMauricio", "Mercado", 405, "Celphone", "798512456", "Email", "mom4@gmail.com", "M");
        schoolService.registerStudent("2A", "Julio", "Student2A", 506, "M", "dadJulio", "Torres", 406, "Celphone", "798512457", "Email", "mom5@gmail.com", "M");
        schoolService.registerStudent("2A", "Miguel", "Student2A", 507, "M", "dadaMiguel", "Mendez", 407, "Celphone", "798512458", "Email", "mom6@gmail.com", "M");
        schoolService.registerStudent("2A", "Luis", "Student2A", 508, "M", "dadLuis", "Vargas", 408, "Celphone", "798512459", "Email", "mom6@gmail.com", "M");
        schoolService.registerStudent("2A", "Jose", "Student2A", 509, "M", "dadJose", "Luna", 409, "Celphone", "798512410", "Email", "mom6@gmail.com", "M");

        schoolService.registerStudent("3A", "Teresa", "Student3A", 510, "M", "momTeresa", "Torres", 410, "Celphone", "798512457", "Email", "mom7@gmail.com", "M");
        schoolService.registerStudent("3A", "Timoteo", "Student3A", 511, "M", "momTimoteo", "Lopez", 411, "Celphone", "798512458", "Email", "mom8@gmail.com", "M");

        schoolService.registerStudent("4A", "Ramiro", "Student3A", 513, "M", "momRamiro", "Milan", 415, "Celphone", "7985552450", "Email", "mom9@gmail.com", "M");
        schoolService.registerStudent("4A", "Lucas", "Student3A", 514, "M", "momLucas", "Montaño", 416, "Celphone", "798555450", "Email", "mom9@gmail.com", "M");
        viewListStudentsByCourse();


        schoolService.assignGradeStudent("1A", 200, 100, "Test", 500, "Spanish-1", "2020");
        schoolService.assignGradeStudent("1A", 201, 50, "Test", 500, "English-1", "2020");
        schoolService.assignGradeStudent("1A", 202, 60, "Test", 500, "German-1", "2020");
        schoolService.assignGradeStudent("1A", 203, 60, "Test", 500, "French-1", "2020");

        schoolService.assignGradeStudent("1A", 200, 55, "Test", 501, "Spanish-1", "2020");
        schoolService.assignGradeStudent("1A", 201, 55, "Test", 501, "English-1", "2020");
        schoolService.assignGradeStudent("1A", 202, 60, "Test", 501, "German-1", "2020");
        schoolService.assignGradeStudent("1A", 203, 60, "Test", 501, "French-1", "2020");

        schoolService.assignGradeStudent("1A", 200, 100, "Test", 502, "Spanish-1", "2020");
        schoolService.assignGradeStudent("1A", 201, 100, "Test", 502, "English-1", "2020");
        schoolService.assignGradeStudent("1A", 202, 100, "Test", 502, "German-1", "2020");
        schoolService.assignGradeStudent("1A", 203, 100, "Test", 502, "French-1", "2020");

        schoolService.assignGradeStudent("1A", 200, 10, "Test", 503, "Spanish-1", "2020");
        schoolService.assignGradeStudent("1A", 201, 0, "Test", 503, "English-1", "2020");
        schoolService.assignGradeStudent("1A", 202, 10, "Test", 503, "German-1", "2020");
        schoolService.assignGradeStudent("1A", 203, 10, "Test", 503, "French-1", "2020");

        schoolService.assignGradeStudent("1A", 200, 50, "Test", 504, "Spanish-1", "2020");
        schoolService.assignGradeStudent("1A", 201, 50, "Test", 504, "English-1", "2020");
        schoolService.assignGradeStudent("1A", 202, 40, "Test", 504, "German-1", "2020");
        schoolService.assignGradeStudent("1A", 203, 40, "Test", 504, "French-1", "2020");


        schoolService.assignGradeStudent("2A", 200, 100, "Test", 505, "Spanish-2", "2020");
        schoolService.assignGradeStudent("2A", 201, 50, "Test", 505, "English-2", "2020");
        schoolService.assignGradeStudent("2A", 202, 60, "Test", 505, "German-2", "2020");
        schoolService.assignGradeStudent("2A", 203, 60, "Test", 505, "French-2", "2020");

        schoolService.assignGradeStudent("2A", 200, 55, "Test", 506, "Spanish-2", "2020");
        schoolService.assignGradeStudent("2A", 201, 55, "Test", 506, "English-2", "2020");
        schoolService.assignGradeStudent("2A", 202, 60, "Test", 506, "German-2", "2020");
        schoolService.assignGradeStudent("2A", 203, 60, "Test", 506, "French-2", "2020");

        schoolService.assignGradeStudent("2A", 200, 100, "Test", 507, "Spanish-2", "2020");
        schoolService.assignGradeStudent("2A", 201, 100, "Test", 507, "English-2", "2020");
        schoolService.assignGradeStudent("2A", 202, 100, "Test", 507, "German-2", "2020");
        schoolService.assignGradeStudent("2A", 203, 100, "Test", 507, "French-", "2020");

        schoolService.assignGradeStudent("2A", 200, 10, "Test", 508, "Spanish-2", "2020");
        schoolService.assignGradeStudent("2A", 201, 0, "Test", 508, "English-2", "2020");
        schoolService.assignGradeStudent("2A", 202, 10, "Test", 508, "German-2", "2020");
        schoolService.assignGradeStudent("2A", 203, 10, "Test", 508, "French-2", "2020");

        schoolService.assignGradeStudent("2A", 200, 50, "Test", 509, "Spanish-2", "2020");
        schoolService.assignGradeStudent("2A", 201, 50, "Test", 509, "English-2", "2020");
        schoolService.assignGradeStudent("2A", 202, 40, "Test", 509, "German-2", "2020");
        schoolService.assignGradeStudent("2A", 203, 40, "Test", 509, "French-2", "2020");


        schoolService.computeAverageStudents("2020");
        viewListKardex();
        viewListKardexHash();
        System.out.printf("******************** AFTER IMPORT - JSON  GRADES 3A TERCERO BASICO ************************************");
        schoolService.importGradeFromFile("src\\lunamary\\resources\\file.json");
        schoolService.computeAverageStudents("2020");
        viewListKardex();
        viewListKardexHash();
        schoolService.exportDataToFile("src\\lunamary\\resources\\ExportTest1.json", schoolService.getSchool().getKardexHashMap());

        System.out.printf("******************** AFTER IMPORT - CSV ************************************");
        schoolService.importGradeFromFile("src\\lunamary\\resources\\file.csv");
        schoolService.computeAverageStudents("2020");
        viewListKardex();
        viewListKardexHash();
        schoolService.exportDataToFile("src\\lunamary\\resources\\ExportTest1.CSV", schoolService.getSchool().getKardexHashMap());
        schoolService.notifyDevices();
        viewNotifications();
        System.out.printf("******************** AFTER EDIT GRADE  ************************************");
        schoolService.editGradeStudent(100, "MODIFIED", 511, "Spanish-3");
        schoolService.editGradeStudent(100, "MODIFIED", 511, "English-3");
        schoolService.computeAverageStudents("2020");
        viewListKardex();
        viewListKardexHash();
        schoolService.notifyDevices();
        viewNotifications();
    }


}
