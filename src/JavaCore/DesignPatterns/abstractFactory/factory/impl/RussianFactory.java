package JavaCore.DesignPatterns.abstractFactory.factory.impl;

import JavaCore.DesignPatterns.abstractFactory.factory.interfaces.TransportAbstractFactory;
import JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.aircraft.TU134;
import JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.car.Niva;
import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Aircraft;
import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Car;

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
