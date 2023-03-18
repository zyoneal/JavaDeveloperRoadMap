package creational.abstractFactory.ExampleCars.factory.transport.impl.aircraft;

import creational.abstractFactory.ExampleCars.transport.interfaces.Aircraft;

public class Boing implements Aircraft {

    @Override
    public void flight() {
        System.out.println("Boing flight");
    }

}
