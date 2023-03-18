package JavaCore.DesignPatterns.structural.bridge.ExampleCar.makers;

public class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }

}
