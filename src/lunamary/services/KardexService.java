package lunamary.services;

import lunamary.model.modelPerson.Director;
import lunamary.model.modelPerson.Kardex;
import lunamary.model.modelPerson.Student;
import lunamary.model.modelSchool.Classroom;

public class KardexService {

    public Kardex createKardex(Student student, Classroom classroom, int finalAverage, String year) {
        Kardex kardex = new Kardex();
        kardex.setStudent(student);
        kardex.setClassroom(classroom);
        kardex.setFinalAverage(finalAverage);
        kardex.setYear(year);
        return kardex;
    }


}
