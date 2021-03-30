package lunamary.services;

import lunamary.model.modelPerson.Device;
import lunamary.model.modelPerson.AbstractPerson;
import lunamary.model.modelPerson.Parent;


public class DeviceService implements IObserver {
    private Device device;

    public DeviceService() {

    }

    public DeviceService(Device device) {
        this.device = device;
    }


    @Override
    public void sendNotification() {

        System.out.println(" ");
        System.out.print(this.device.getType() + " ");
        System.out.print(this.device.getIdentifier() + " ");
        System.out.print(this.device.getTemplateMsj()+ " ");
        System.out.println(" ");


    }

    public Device createDevice(String type, String identified) {
        Device device = new Device(type,identified);
        return device;

    }


}
