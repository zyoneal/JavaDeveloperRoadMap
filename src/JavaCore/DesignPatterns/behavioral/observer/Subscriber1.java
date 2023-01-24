package JavaCore.DesignPatterns.observer;

public class Subscriber1 implements PublisherActionListener{

    @Override
    public void doAction(String message) {
        System.out.println(message + " from " + this.getClass().getName());
    }

}
