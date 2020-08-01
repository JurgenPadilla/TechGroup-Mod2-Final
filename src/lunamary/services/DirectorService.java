package lunamary.services;

import lunamary.modelPerson.Director;
import lunamary.modelSchool.Classroom;

import java.util.List;


public class DirectorService {
    Director director;

    public DirectorService(Director director) {
        this.director = director;
    }

    public void assignAverage(List<Classroom> classroom, String year, Integer averageExpelled, Integer averagescholarship, String name) {
        for (Classroom var : classroom) {
            if (name.equals(var.getName())) {
                var.setMinimumAverageApprobation(averageExpelled);
                var.setAverageScholarshipGrade(averagescholarship);
            }

        }


    }
}
