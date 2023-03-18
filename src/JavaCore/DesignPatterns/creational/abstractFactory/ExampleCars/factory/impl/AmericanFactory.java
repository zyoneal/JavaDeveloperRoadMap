package creational.abstractFactory.ExampleCars.factory.impl;

import creational.abstractFactory.ExampleCars.factory.interfaces.TransportAbstractFactory;
import creational.abstractFactory.ExampleCars.factory.transport.impl.aircraft.Boing;
import creational.abstractFactory.ExampleCars.factory.transport.impl.car.Porsche;
import creational.abstractFactory.ExampleCars.transport.interfaces.Aircraft;
import creational.abstractFactory.ExampleCars.transport.interfaces.Car;

public class AmericanFactory implements TransportAbstractFactory {

    @Override
    public Car createCar() {
        return new Porsche();
    }

    @Override
    public Aircraft createAircraft() {
        return new Boing();
    }

}
