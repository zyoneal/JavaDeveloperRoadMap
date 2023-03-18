package JavaCore.DesignPatterns.behavioral.observer.ExampleSubscribers;

public class Subscriber1 implements PublisherActionListener {

    @Override
    public void doAction(String message) {
        System.out.println(message + " from " + this.getClass().getName());
    }

}
