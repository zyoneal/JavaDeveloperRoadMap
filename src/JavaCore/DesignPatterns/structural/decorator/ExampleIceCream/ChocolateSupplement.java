package JavaCore.DesignPatterns.structural.decorator.ExampleIceCream;

public class ChocolateSupplement implements IceCream {

    public IceCream iceCream;

    public ChocolateSupplement(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getName() {
        return iceCream.getName() + " chocolate supplement";
    }

}
