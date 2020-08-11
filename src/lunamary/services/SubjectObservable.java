package lunamary.services;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;

public class SubjectObservable implements IObservable {

    private MyCircularDoublyLinkedList<IObserver> seviceNotification;

    public SubjectObservable() {
        this.seviceNotification = new MyCircularDoublyLinkedList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        if (!this.seviceNotification.contains(observer)) {
            this.seviceNotification.add(observer);
        }
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.seviceNotification.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if (this.seviceNotification.size() != 0) {
            for (int i = 0; i < this.seviceNotification.size(); i++) {
                this.seviceNotification.get(i).sendNotification();
            }
        } else {
            System.out.println("No devices to be notified.");
        }


    }
}
