package lunamary.services;

import lunamary.modelPerson.Person;

public class NotificationService implements IObserver {
    private final Person senderNotification;
    private final Person receiversNotification;

    public NotificationService(Person to, Person from) {
        this.senderNotification = from;
        this.receiversNotification = to;
    }

    @Override
    public void sendNotification() {
        System.out.println("***********Notification******* " + "\n"
                + "Device receiver: " + receiversNotification.getDeviceList().get(0).getType() + " " + receiversNotification.getDeviceList().get(0).getIdentifier() + "\n"
                + "Dear Mis/ Mister " + receiversNotification.getName() + " " + receiversNotification.getName() + "\n"
                + "This notification is to notify that your son / daugter  has been accomplishing the expectations required.\n"
                + "I would like to get a meeting to discuss about it." + "\n"
                + "Best Regards \n"
                + senderNotification.getName() + senderNotification.getLastname());

    }
}
