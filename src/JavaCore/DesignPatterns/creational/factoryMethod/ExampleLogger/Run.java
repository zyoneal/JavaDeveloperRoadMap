package JavaCore.DesignPatterns.creational.factoryMethod.ExampleLogger;

public class Run {

    public static void main(String[] args) {
        LoggingProviders typeOfLoggingProvidersFromConfigFile = getTypeOfLoggingProvidersFromConfigFile();
        ILogger logger = LoggerProviderFactory.getLoggingProvider(typeOfLoggingProvidersFromConfigFile);
        logger.logMessage("Hello Factory Method design pattern");
    }

    private static LoggingProviders getTypeOfLoggingProvidersFromConfigFile() {
        return LoggingProviders.LOG4NET;
    }

}