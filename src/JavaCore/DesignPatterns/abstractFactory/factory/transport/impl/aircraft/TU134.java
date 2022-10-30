package JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.aircraft;

import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Aircraft;

public class TU134 implements Aircraft {

    @Override
    public void flight() {
        System.out.println("TU134 flight");
    }

}
