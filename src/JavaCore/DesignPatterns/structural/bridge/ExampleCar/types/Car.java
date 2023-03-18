package structural.bridge.ExampleCar.types;

import structural.bridge.ExampleCar.makers.Make;

public abstract class Car {

    Make make;

    public Car(Make m) {
        this.make = m;
    }

    abstract void showType();

    public void showDetails(){
        showType();
        make.setMake();
    }

}
