package JavaCore.DesignPatterns.structural.decorator.ExampleIceCream;

public class Demo {

    public static void main(String[] args) {
        IceCream vanillaIceCream = new VanillaIceCream();
        vanillaIceCream = new ChocolateSupplement(vanillaIceCream);
        vanillaIceCream = new StrawberrySupplement(vanillaIceCream);
        System.out.println("Result of your Vanilla ice cream: " + vanillaIceCream);

        IceCream bananaIceCream = new BananaIceCream();
        bananaIceCream = new ChocolateSupplement(bananaIceCream);
        bananaIceCream = new CoconutFlakes(bananaIceCream);
        System.out.println("Result of your Banana ice cream: " + bananaIceCream);
    }

}
