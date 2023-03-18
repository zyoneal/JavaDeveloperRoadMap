package creational.factoryMethod.ExampleLogger;

public class LoggerProviderFactory {

    public static ILogger getLoggingProvider(LoggingProviders loggingProviders) {
        switch (loggingProviders) {
            case LOG4NET -> {
                return new Log4NetLogger();
            }
            default -> {
                return new EnterpriseLogger();
            }
        }
    }
}
