package creational.abstractFactory.ExampleCars.factory.transport.impl.aircraft;

import creational.abstractFactory.ExampleCars.transport.interfaces.Aircraft;

public class TU134 implements Aircraft {

    @Override
    public void flight() {
        System.out.println("TU134 flight");
    }

}
