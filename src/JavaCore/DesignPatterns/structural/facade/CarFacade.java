package JavaCore.DesignPatterns.facade;

import facade.parts.Door;
import facade.parts.Wheel;
import facade.parts.Zazhiganie;

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
