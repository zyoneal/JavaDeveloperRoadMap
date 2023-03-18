package JavaCore.DesignPatterns.creational.singleton;

public class TestSingleton {

    private static TestSingleton instance = null;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    // приватный конструктор
    private TestSingleton() {
    }

    public void print() {
        System.out.println(this);
    }

    public void stop() {
        System.out.println("stop");
    }

}
