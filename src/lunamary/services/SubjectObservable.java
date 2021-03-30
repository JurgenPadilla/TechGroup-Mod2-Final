package lunamary.services;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;

public class SubjectObservable implements IObservable {

    private MyCircularDoublyLinkedList<IObserver> serviceDevices;


    public SubjectObservable() {
        this.serviceDevices = new MyCircularDoublyLinkedList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (!this.serviceDevices.contains(observer)) {
            this.serviceDevices.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.serviceDevices.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (this.serviceDevices.size() != 0) {
            for (int i = 0; i < this.serviceDevices.size(); i++) {
                this.serviceDevices.get(i).sendNotification();
            }
        } else {
            System.out.println("No devices to be notified.");
        }
    }

}
