package JavaCore.DesignPatterns.creational.factoryMethod.ExampleLogger;

public class Log4NetLogger implements ILogger {
    @Override
    public void logMessage(String message) {
        System.out.println("Log4NetLogger: " + message);
    }

}
