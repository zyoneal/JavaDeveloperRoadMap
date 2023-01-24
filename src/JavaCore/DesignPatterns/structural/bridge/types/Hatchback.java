package JavaCore.DesignPatterns.bridge.types;

import JavaCore.DesignPatterns.bridge.makers.Make;

public class Hatchback extends Car {

    public Hatchback(Make m) {
        super(m);
    }

    @Override
    public void showType() {
        System.out.println("Hatchback");
    }

}
