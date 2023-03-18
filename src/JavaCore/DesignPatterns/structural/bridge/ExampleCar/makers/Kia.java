package JavaCore.DesignPatterns.structural.bridge.ExampleCar.makers;

public class Kia implements Make {

    @Override
    public void setMake() {
        System.out.println("Kia");
    }

}
