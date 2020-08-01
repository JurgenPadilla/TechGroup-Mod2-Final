package lunamary.modelPerson;

public class Device {

    private String type; // App, Movil, Email
    private String identifier; // number or email


    public Device(String type, String identifier) {
        this.type = type;
        this.identifier = identifier;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


}
