package JavaCore.OOP.SOLID.OpenClosed;

public class SaveComputerToDB implements Saveable {

    @Override
    public void save(String path, Computer computer) {
        System.out.println("Save to DB: " + path + ", " + computer);
    }

}
