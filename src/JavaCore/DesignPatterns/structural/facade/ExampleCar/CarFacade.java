package JavaCore.DesignPatterns.structural.facade.ExampleCar;


import JavaCore.DesignPatterns.structural.facade.ExampleCar.parts.Door;
import JavaCore.DesignPatterns.structural.facade.ExampleCar.parts.Wheel;
import JavaCore.DesignPatterns.structural.facade.ExampleCar.parts.Zazhiganie;

public class CarFacade {

    private Door door = new Door();
    private Zazhiganie zazhiganie = new Zazhiganie();
    private Wheel wheel = new Wheel();

    public void go() {
        door.open();
        zazhiganie.fire();
        wheel.turn();
    }

}
