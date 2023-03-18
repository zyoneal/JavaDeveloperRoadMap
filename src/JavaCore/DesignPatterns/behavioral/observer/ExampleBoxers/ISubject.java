package behavioral.observer.ExampleBoxers;

public interface ISubject {

    void attachObserve(IObserver observer);

    void detachObserver(IObserver observer);

    void Notify();

}
