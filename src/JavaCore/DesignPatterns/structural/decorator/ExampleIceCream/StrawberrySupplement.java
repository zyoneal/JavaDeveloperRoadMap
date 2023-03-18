package JavaCore.DesignPatterns.structural.decorator.ExampleIceCream;

public class StrawberrySupplement implements IceCream {

    public IceCream iceCream;

    public StrawberrySupplement(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getName() {
        return iceCream.getName() + " strawberry supplement";
    }

}
