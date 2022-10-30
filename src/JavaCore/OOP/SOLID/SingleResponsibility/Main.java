package JavaCore.OOP.SOLID.SingleResponsibility;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer("IBM", 8000);
        ComputerSaver saver = new ComputerSaver();
        saver.saveToFile("out.dat", computer);
        saver.saveToDB("postgesql", computer);
    }

}
