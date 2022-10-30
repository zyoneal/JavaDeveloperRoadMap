package JavaCore.OOP.SOLID.LiskovSubstitution;

public class SaveComputerToDB implements Saveable {

    @Override
    public void save(String path, Computer computer) {
        System.out.println("Save to DB: " + path + ", " + computer);
    }

}
