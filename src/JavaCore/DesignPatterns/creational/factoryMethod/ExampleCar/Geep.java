package JavaCore.DesignPatterns.creational.factoryMethod.ExampleCar;

public class Geep implements Car{

    @Override
    public void drive() {
        System.out.println("Drive speed is 50 km/h");
    }

    @Override
    public void stop() {
        System.out.println("Stopped at 5 sec");
    }

}
