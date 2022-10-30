package JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.car;

import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Car;

public class Porsche implements Car {

    @Override
    public void drive() {
        System.out.println("Porsche drive");
    }

    @Override
    public void stop() {
        System.out.println("Porsche stop");
    }

}
