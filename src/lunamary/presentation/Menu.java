package lunamary.presentation;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.Kardex;
import lunamary.model.modelPerson.Student;
import lunamary.model.modelPerson.Teacher;
import lunamary.model.modelSchool.Classroom;
import lunamary.model.modelSchool.Subject;
import lunamary.services.SchoolService;

import java.util.Map;
import java.util.Scanner;

public class Menu {
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
                System.out.println("\t 4. Register Teacher");
            } else {
                System.out.println("\t 4.  Register Teacher  (*)");
            }
            ;
            if (selectOption.contains("5") == false) {
                System.out.println("\t 5. Register Subject");
            } else {
                System.out.println("\t 5. Director set Average by Course  (*)");
            }
            ;
            if (selectOption.contains("6") == false) {
                System.out.println("\t 6. Director set Average by classroom");
            } else {
                System.out.println("\t 6. Director set Average by Course  (*)");
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
            System.out.println("\t 10. Director generate General Report");
            System.out.println("\t Para salir ingrese 's'. ");
            System.out.println("-------------------------------------------------");
            System.out.print("Seleccione una opcion: ");
            String selectOption = scanner.nextLine();
            System.out.println("#################################################\n\n");

            switch (selectOption.toLowerCase()) {
//                case "1": uiRegisterNewSchool(); option = false; break;
//                case "2": uiRegisterDirectorSchool(); option = false; break;
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
                    uiImportFileJson();
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

    public void stepNewSchoolAndSchool(String nameSchool, String address, String director, String lastNameDirector, int ci) {
//        schoolService = new SchoolService(nameSchool, address);
//        schoolService.createSchool(nameSchool, address);
//        schoolService.registerDirector(director, lastNameDirector, ci);
    }

    public void stepNewSchool(String nameSchool, String address) {
        schoolService = new SchoolService(nameSchool, address);
        //schoolService.createSchool(nameSchool, address);
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
                String name = teacher.getName() + " " + teacher.getLastname()+" ("+teacher.getCi()+")";;
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
        System.out.print("\t Insert the promedio: ");
        String average = scanner.nextLine();
        System.out.print("\t Insert the promedio minimo de aprobacion: ");
        String averageMinApproval = scanner.nextLine();
        schoolService.registerAverageClassroom(nameClassroom, Integer.parseInt(average), Integer.parseInt(averageMinApproval));
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
        //schoolService.registerStudent(nameClassroom, nameStudent, lastNameStudent, Integer.parseInt(ciStudent), nameParent, lastNameParent, Integer.parseInt(ciParent), typeDevice, numberDevice, "Email", email);
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
            System.out.println("    List sort Kardex by Classroom :");
            for (Map.Entry<String, MyLinkedList<Kardex>> listHashlist : listHash.entrySet()) {
                System.out.println(listHashlist.getKey() + ": ");
                for (int i = 0; i < listHashlist.getValue().size(); i++) {
                    Kardex kardex = (Kardex) listHashlist.getValue().get(i);
                    String name = kardex.getStudent().getName() + " - " + kardex.getFinalAverage();
                    System.out.println("    • " + name);
                    System.out.println();
                }
            }


        }

    }
}
