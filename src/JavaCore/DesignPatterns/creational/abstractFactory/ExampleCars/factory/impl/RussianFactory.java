package creational.abstractFactory.ExampleCars.factory.impl;

import creational.abstractFactory.ExampleCars.factory.interfaces.TransportAbstractFactory;
import creational.abstractFactory.ExampleCars.factory.transport.impl.aircraft.TU134;
import creational.abstractFactory.ExampleCars.factory.transport.impl.car.Niva;
import creational.abstractFactory.ExampleCars.transport.interfaces.Aircraft;
import creational.abstractFactory.ExampleCars.transport.interfaces.Car;

public class RussianFactory implements TransportAbstractFactory {

    @Override
    public Car createCar() {
        return new Niva();
    }

    @Override
    public Aircraft createAircraft() {
        return new TU134();
    }

}
