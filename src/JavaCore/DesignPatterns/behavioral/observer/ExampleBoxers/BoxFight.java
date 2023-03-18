package JavaCore.DesignPatterns.behavioral.observer.ExampleBoxers;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class BoxFight implements ISubject{

    public List<IObserver> observers;

    public int roumdNumber;

    private Random random = new Random();

    public int boxerAScore;

    public int boxerBScore;

    public BoxFight() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void attachObserve(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void nextRound() {
        roumdNumber++;
        boxerAScore += random.nextInt(0,5);
        boxerBScore += random.nextInt(0,5);
        notify();
    }

    @Override
    public void Notify() {
        for (var observer : observers) {
            observer.update(this);
        }
    }

}
