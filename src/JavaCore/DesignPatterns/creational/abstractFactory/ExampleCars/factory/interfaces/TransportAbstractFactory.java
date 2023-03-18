package creational.abstractFactory.ExampleCars.factory.interfaces;

import creational.abstractFactory.ExampleCars.transport.interfaces.Aircraft;
import creational.abstractFactory.ExampleCars.transport.interfaces.Car;

// фабрика по созданию транспортных средств
// когда нужно создавать разные семейства обьектов в одном месте
public interface TransportAbstractFactory {

    Car createCar();

    Aircraft createAircraft();

}
