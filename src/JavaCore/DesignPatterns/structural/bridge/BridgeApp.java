package JavaCore.DesignPatterns.bridge;

// Мост позволяет разделить имплементацию от ее абстракции, таким образом
//реализация может быть изменена отдельно от абстракции, поскольку она не
//наследуется от нее напрямую.

import JavaCore.DesignPatterns.bridge.makers.Kia;
import JavaCore.DesignPatterns.bridge.types.Car;
import JavaCore.DesignPatterns.bridge.types.Sedan;

public class BridgeApp {

    public static void main(String[] args) {
        Car car = new Sedan(new Kia());
        car.showDetails();
    }

}
