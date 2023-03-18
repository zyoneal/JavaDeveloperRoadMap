package SOLID.SingleResponsibility;
public class ComputerSaver {

    public void saveToFile(String path, Computer computer) {
        System.out.println("Save to file: " + path + ", " + computer);
    }

    public void saveToDB(String path, Computer computer) {
        System.out.println("Save to DB " + path + ", " + computer);
    }

}
