package JavaCore.DesignPatterns.abstractFactory.factory.impl;

import JavaCore.DesignPatterns.abstractFactory.factory.interfaces.TransportAbstractFactory;
import JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.aircraft.Boing;
import JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.car.Porsche;
import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Aircraft;
import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Car;

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
