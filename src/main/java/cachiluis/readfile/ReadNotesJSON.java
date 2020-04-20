package cachiluis;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadNotesJSON extends ReadRegisterGrades {

    ReadNotesJSON(String path) {
        super(path);
        readFile();
    }

    @Override
    protected void readFile() {
        JSONParser jsonParser = new JSONParser();

        try {
            FileReader reader = new FileReader(super.path);
            //Read JSON file
            super.file = jsonParser.parse(reader);

            JSONArray studentList = (JSONArray) super.file;
            System.out.println(studentList);

            //Iterate over employee array
            studentList.forEach(student -> parseStudent((JSONObject) student));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        notesToHashMap();
    }

    private void parseStudent(JSONObject student) {
        //Get employee object within list
        JSONObject studentObj = (JSONObject) student.get("student");

        RegisterNotes registerNotes = new RegisterNotes((String) studentObj.get("id"));

        //Get employee first name
        for (int i = 1; i <= 4 ; i++) {
            int note = (int) studentObj.get(i);
            registerNotes.setGrades(i, note);
        }
    }

}
