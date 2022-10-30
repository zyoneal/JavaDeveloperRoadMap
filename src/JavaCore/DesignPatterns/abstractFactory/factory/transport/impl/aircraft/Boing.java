package JavaCore.DesignPatterns.abstractFactory.factory.transport.impl.aircraft;

import JavaCore.DesignPatterns.abstractFactory.transport.interfaces.Aircraft;

public class Boing implements Aircraft {

    @Override
    public void flight() {
        System.out.println("Boing flight");
    }

}
