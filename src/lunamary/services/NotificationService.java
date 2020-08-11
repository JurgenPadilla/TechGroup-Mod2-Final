package lunamary.services;

import lunamary.model.modelPerson.AbstractPerson;
import lunamary.model.modelPerson.Device;

public class NotificationService implements IObserver {
    private final AbstractPerson person;
    private final Device device;

    public NotificationService(AbstractPerson senderNotification, Device deviceReceiversNotification) {
        this.person = senderNotification;
        this.device = deviceReceiversNotification;
    }


    @Override
    public void sendNotification() {

        print("***********Notification******* " + "\n"
                + "Device receiver: " + device.getType() + " " + device.getIdentifier() + "\n"
                + "Dear Mis/ Mister " + device.getOwner().getName() + " " + device.getOwner().getLastname() + "\n"
                + "This notification is to notify that your son/daugter  has not been accomplishing the expectations required.\n"
                + "I would like to get a meeting to discuss about it." + "\n"
                + "Best Regards \n"
                + person.getName() + " " + person.getLastname());


    }


    public void print(String text) {
        System.out.print(text);
    }

}
