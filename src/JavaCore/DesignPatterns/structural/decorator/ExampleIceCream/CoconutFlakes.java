package structural.decorator.ExampleIceCream;

public class CoconutFlakes implements IceCream {

    public IceCream iceCream;

    public CoconutFlakes(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getName() {
        return iceCream.getName() + " coconut flakes";
    }

}
