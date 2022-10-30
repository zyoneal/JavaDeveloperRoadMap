package JavaCore.DesignPatterns.abstractFactory.factory.interfaces;

import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Aircraft;
import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Car;

// фабрика по созданию транспортных средств
// когда нужно создавать разные семейства обьектов в одном месте
public interface TransportAbstractFactory {

    Car createCar();

    Aircraft createAircraft();

}
