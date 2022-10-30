package JavaCore.OOP.SOLID.DependencyInversion;

public class MySQL implements Database {

    public void save(IForm form) {
        System.out.println("write form to db");
    }

}
