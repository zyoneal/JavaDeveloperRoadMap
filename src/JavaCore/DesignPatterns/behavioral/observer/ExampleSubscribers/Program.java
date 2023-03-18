package JavaCore.DesignPatterns.behavioral.observer.ExampleSubscribers;

// Наблюдатель позволяет автоматически реагировать многим объектам на
//изменение состояния определенного другого объекта.

// Связь обьектов по принципу publish/subscriber
// Наблюдатель ждет наступления определенного события и оповещает об этом всех слушателей
// Помогает реализовать слабую зависимость между обьектами

public class Program {

    public static void main(String[] args) {
        Subscriber1 subscriber1 = new Subscriber1();
        Subscriber2 subscriber2 = new Subscriber2();

        Publisher publisher = new Publisher();

        publisher.addListener(subscriber1);
        publisher.addListener(subscriber2);

        publisher.createNewMessage("Message!");
    }

}
