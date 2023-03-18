package JavaCore.DesignPatterns.structural.bridge.ExampleCar.types;


import JavaCore.DesignPatterns.structural.bridge.ExampleCar.makers.Make;

public class Hatchback extends Car {

    public Hatchback(Make m) {
        super(m);
    }

    @Override
    public void showType() {
        System.out.println("Hatchback");
    }

}
