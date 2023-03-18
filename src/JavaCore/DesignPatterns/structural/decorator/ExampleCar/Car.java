package JavaCore.DesignPatterns.structural.decorator.ExampleCar;

public abstract class Car {
    protected String brandName;

    public void go() {
        System.out.println("I'm " + brandName + " and I'm on my way");
    }

}
