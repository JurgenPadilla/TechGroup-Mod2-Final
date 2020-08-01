package lunamary.services;

public interface IObservable {
    void registerObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();

}
