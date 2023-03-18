package JavaCore.DesignPatterns.structural.bridge.ExampleCar;

// Мост позволяет разделить имплементацию от ее абстракции, таким образом
//реализация может быть изменена отдельно от абстракции, поскольку она не
//наследуется от нее напрямую.


import JavaCore.DesignPatterns.structural.bridge.ExampleCar.makers.Kia;
import JavaCore.DesignPatterns.structural.bridge.ExampleCar.types.Car;
import JavaCore.DesignPatterns.structural.bridge.ExampleCar.types.Sedan;

public class BridgeApp {

    public static void main(String[] args) {
        Car car = new Sedan(new Kia());
        car.showDetails();
    }

}
