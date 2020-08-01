package lunamary.services;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;

public class SubjectObservable implements IObservable {

    private MyCircularDoublyLinkedList<IObserver> seviceNotification;

    public SubjectObservable() {
        this.seviceNotification = new MyCircularDoublyLinkedList<>();
    }
//    public void notifyNow(int grade)  //alert that grade is updated
//    {
//        GradeService gradeService = new GradeService();
//        gradeService.validateGrade(50);
//    }

    @Override
    public void registerObserver(IObserver observer) {

    }

    @Override
    public void removeObserver(IObserver observer) {

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < this.seviceNotification.size(); i++) {
            this.seviceNotification.get(i).sendNotification();
        }

    }
}
