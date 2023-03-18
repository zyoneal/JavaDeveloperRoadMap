package SOLID.LiskovSubstitution;

public class SaveComputerToFile implements Saveable {

    @Override
    public void save(String path, Computer computer) {
        System.out.println("Save to file: " + path + ", " + computer);
    }

}
