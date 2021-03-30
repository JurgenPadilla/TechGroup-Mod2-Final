package lunamary.services;

import lunamary.model.modelPerson.Director;
import lunamary.model.modelSchool.Classroom;


public class DirectorService {

    public DirectorService() {

    }

    public Director createDirector(String name, String lastname, int age, String gender) {
        Director director = new Director(name, lastname, age, gender);
        return director;
    }

    public void assignAverage(Classroom classroom, int  averageScholarshipGrade, int minimumAverageApprobation, int expelled) {
        classroom.setMinimumAverageApprobation(minimumAverageApprobation);
        classroom.setAverageScholarshipGrade(averageScholarshipGrade);
        classroom.setAverageExpelled(expelled);

    }
}
