package lunamary.model.modelPerson;

public class Device {

    private String type;
    private String identifier;
    private String templateMsj;


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

    public String getTemplateMsj() {
        return templateMsj;
    }

    public void setTemplateMsj(String text) {
        this.templateMsj = text;
    }


}
