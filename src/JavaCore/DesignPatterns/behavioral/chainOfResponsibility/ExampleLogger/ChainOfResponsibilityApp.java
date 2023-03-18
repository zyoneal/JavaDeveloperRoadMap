package JavaCore.DesignPatterns.behavioral.chainOfResponsibility.ExampleLogger;

// Цепочка Ответственностей обеспечивает обработку объекта путём
//передачи его по цепочке до тех пор, пока не будет произведена обработка какой-либо
//из звеньев.

// Цепочка ответственности (обязанностей).
// Данный шаблон предназначен для организации в системе уровней ответственности (или обязанностей)
// и  позволяет определить должно ли сообщение обрабатываться на том уровне,
// где оно было получено, или же оно должно передаваться для обработки другому объекту.

public class ChainOfResponsibilityApp {

    public static void main(String[] args) {
        Logger smsLogger = new SMSLogger(Level.ERROR);
        Logger fileLogger = new FileLogger(Level.DEBUG);
        Logger emailLogger = new EmailLogger(Level.INFO);
        smsLogger.setNext(fileLogger);
        fileLogger.setNext(emailLogger);

        smsLogger.writeMessage("Все хорошо", Level.INFO);
        smsLogger.writeMessage("Идет режим отладки", Level.DEBUG);
        smsLogger.writeMessage("Система упала", Level.ERROR);
    }

}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger {

    int priority;

    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);

}

class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("SMS " + message);
    }

}

class FileLogger extends Logger {

    public FileLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("Записываем в файл: " + message);
    }

}

class EmailLogger extends Logger {

    public EmailLogger(int priority) {
        super(priority);
    }

    public void write(String message) {
        System.out.println("E-mail сообщение: " + message);
    }

}
