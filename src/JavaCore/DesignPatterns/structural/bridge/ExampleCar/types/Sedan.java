package structural.bridge.ExampleCar.types;

import structural.bridge.ExampleCar.makers.Make;

public class Sedan extends Car {

    public Sedan(Make m) {
        super(m);
    }

    @Override
    public void showType() {
        System.out.println("Sedan");
    }

}
