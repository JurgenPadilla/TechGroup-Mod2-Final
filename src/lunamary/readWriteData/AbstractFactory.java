package lunamary.readWriteData;

public class AbstractFactory {

    public static ReadWriteFile createFile(String path) {
        System.out.println(path);
        String[] pathSplit = path.split("\\.");
        String extension = pathSplit[pathSplit.length - 1];
        if (extension.toUpperCase().equals("CSV")) {
            return new ReadWriteCSV(path);
        } else if (extension.toUpperCase().equals("JSON")) {
            return new ReadWriteJSON(path);
        } else {
            return null;
        }

    }
}


