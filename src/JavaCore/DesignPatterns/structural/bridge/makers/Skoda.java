package JavaCore.DesignPatterns.bridge.makers;

public class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }

}
