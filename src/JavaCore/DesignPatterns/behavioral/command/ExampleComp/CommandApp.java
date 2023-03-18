package JavaCore.DesignPatterns.behavioral.command.ExampleComp;

// Команда - позволяет инкапсулировать всю информацию, необходимую для
// выполнение определенных операций, которые могут быть выполнены позже,
// используя объект команды.

public class CommandApp {

    public static void main(String[] args) {
        Comp comp = new Comp();
        User user = new User(new StartCommand(comp),new StopCommand(comp),new ResetCommand(comp));

        user.startComputer();
        user.stopComputer();
        user.resetComputer();
    }

}

interface Command {

    void execute();

}

// Reciver
class Comp {

    void start() {
        System.out.println("Start");
    }

    void stop() {
        System.out.println("Stop");
    }

    void reset() {
        System.out.println("Reset");
    }

}

// ConcreteCommand
class StartCommand implements Command {

    Comp comp;

    public StartCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.start();
    }

}

class StopCommand implements Command {

    Comp comp;

    public StopCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.stop();
    }

}

class ResetCommand implements Command {

    Comp comp;

    public ResetCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.reset();
    }

}

// Invoker
class User {

    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }

}
