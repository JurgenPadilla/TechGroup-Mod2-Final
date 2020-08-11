package lunamary.model.modelPerson;

public class Device {

    private String type;
    private String identifier;
    private AbstractPerson owner;


    public Device(String type, String identifier, AbstractPerson owner) {
        this.type = type;
        this.identifier = identifier;
        this.owner = owner;

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

    public AbstractPerson getOwner() {
        return owner;
    }

    public void setOwner(AbstractPerson owner) {
        this.owner = owner;
    }


}
