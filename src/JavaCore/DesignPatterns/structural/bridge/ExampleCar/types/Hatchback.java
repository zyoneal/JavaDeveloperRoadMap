package structural.bridge.ExampleCar.types;

import structural.bridge.ExampleCar.makers.Make;

public class Hatchback extends Car {

    public Hatchback(Make m) {
        super(m);
    }

    @Override
    public void showType() {
        System.out.println("Hatchback");
    }

}
