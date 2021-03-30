package lunamary.model.modelPerson;

public class Parent extends AbstractPerson {

    private boolean requiredNotification;


    private Device device;

    public Parent(String name, String lastName, int ci, String gender) {
        super(name, lastName, ci, gender);

    }

    public boolean isRequiredNotification() {
        return requiredNotification;
    }

    public void setRequiredNotification(boolean requiredNotification) {
        this.requiredNotification = requiredNotification;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
