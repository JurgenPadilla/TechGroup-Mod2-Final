package cachiluis.readfile;

import cachiluis.Course;
import cachiluis.Kardex;
import cachiluis.School;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadNotesJSON extends ReadRegisterGrades {

    public ReadNotesJSON(String path) {
        super(path);
        readFile();
    }

    @Override
    protected void readFile() {
        try {
            FileReader reader = new FileReader(super.path);
            parseSubject(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void parseSubject(FileReader file){
        JSONParser jsonParser = new JSONParser();
        try {
            super.file = jsonParser.parse(file);
            JSONObject jsonFile = (JSONObject) super.file;

            String subject = (String) jsonFile.get("subject");
            String curseName = (String) jsonFile.get("course");
            int year = Integer.parseInt(String.valueOf(jsonFile.get("year")));
            School school = School.getSchool();
            Course curse =  school.getCurse(curseName, year); //currently year is not used


            JSONArray studentList = (JSONArray) jsonFile.get("students");

//            JSONArray studentList = (JSONArray) super.file;
            System.out.println(studentList);

            //Iterate over employee array
            studentList.forEach(student -> parseStudent((JSONObject) student, curse));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

    }

    private void parseStudent(JSONObject student, Course course) {
        //Get Students Values id, name etc
        Kardex studentKardex = course.getStudentKardex(
                (String) student.get("id"), (String) student.get("name"));

        JSONArray notes = (JSONArray) student.get("notes");
        System.out.println(notes);
        //Get notes of the students
        notes.forEach(notesGrade -> {
                int notess[] = parseNotes((JSONObject) notesGrade);
                studentKardex.setGradesForSubject("math", notess[0], notess[1]);
        });
        ;
//
    }

    private int[] parseNotes(JSONObject notesGrade) {
        String period = notesGrade.get("period").toString();
        String note = notesGrade.get("grade").toString();
        int notes[] = {Integer.parseInt(period), Integer.parseInt(note)};
        return notes;
//        registerNotes.setGrades(Integer.parseInt(period), Integer.parseInt(note));
    }

}
