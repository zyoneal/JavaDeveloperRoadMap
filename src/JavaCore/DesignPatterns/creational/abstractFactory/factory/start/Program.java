package JavaCore.DesignPatterns.abstractFactory.factory.start;

import JavaCore.DesignPatterns.abstractFactory.factory.impl.RussianFactory;
import JavaCore.DesignPatterns.abstractFactory.factory.interfaces.TransportAbstractFactory;
import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Aircraft;

//Абстрактная Фабрика предоставляет простой интерфейс для создания объектов,
//принадлежащие к тому или иному семейству.

// Использовать когда есть много разных типов одних обьектов
// Например игрушки: мягкие, деревянные
// Машины: Русские, Американские

public class Program {

    public static void main(String[] args) {
        TransportAbstractFactory russianFactory = new RussianFactory();
        Aircraft aircraft = russianFactory.createAircraft();
        aircraft.flight();
    }

}
