package creational.abstractFactory.ExampleCars.factory.start;
//Абстрактная Фабрика предоставляет простой интерфейс для создания объектов,
//принадлежащие к тому или иному семейству.

// Использовать когда есть много разных типов одних обьектов
// Например игрушки: мягкие, деревянные
// Машины: Русские, Американские

import creational.abstractFactory.ExampleCars.factory.impl.RussianFactory;
import creational.abstractFactory.ExampleCars.factory.interfaces.TransportAbstractFactory;
import creational.abstractFactory.ExampleCars.transport.interfaces.Aircraft;

public class Program {

    public static void main(String[] args) {
        TransportAbstractFactory russianFactory = new RussianFactory();
        Aircraft aircraft = russianFactory.createAircraft();
        aircraft.flight();
    }

}
