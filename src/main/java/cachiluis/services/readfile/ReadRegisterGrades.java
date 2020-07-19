package cachiluis.services.readfile;

public abstract class ReadRegisterGrades {
    protected String path;
    protected Object file;

    ReadRegisterGrades(String path) {
        this.path = path;
    }

    protected abstract void readFile();


}
