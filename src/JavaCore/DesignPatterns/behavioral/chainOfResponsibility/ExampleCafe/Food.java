package behavioral.chainOfResponsibility.ExampleCafe;

import java.util.ArrayList;

public class Food {

    String name;

    public ArrayList<String> ingradients;

    public Food(String name, ArrayList<String> ingradients) {
        this.name = name;
        this.ingradients = ingradients;
    }

}
