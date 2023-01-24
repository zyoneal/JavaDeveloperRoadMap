package JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.car;

import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Car;

public class Niva implements Car {

    @Override
    public void drive() {
        System.out.println("Niva drive");
    }

    @Override
    public void stop() {
        System.out.println("Niva stop");
    }

}
