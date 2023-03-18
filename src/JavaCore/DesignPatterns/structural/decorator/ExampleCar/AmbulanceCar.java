package JavaCore.DesignPatterns.structural.decorator.ExampleCar;

public class AmbulanceCar extends DecoratorCar {
    public AmbulanceCar(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public void go() {
        super.go();
        System.out.println("Beeep - beeep - beeeeep");
    }

}
