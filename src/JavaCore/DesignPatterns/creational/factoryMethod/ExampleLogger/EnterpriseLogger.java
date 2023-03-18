package JavaCore.DesignPatterns.creational.factoryMethod.ExampleLogger;

public class EnterpriseLogger implements ILogger {
    @Override
    public void logMessage(String message) {
        System.out.println("Enterprise logger: " + message);
    }

}
