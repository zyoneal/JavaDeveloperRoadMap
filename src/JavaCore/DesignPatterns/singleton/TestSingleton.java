package JavaCore.DesignPatterns.singleton;

public class TestSingleton {

    private static final TestSingleton instance = new TestSingleton();

    public static TestSingleton getInstance() {
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
