package JavaCore.DesignPatterns.creational.abstractFactory.ExampleToys;

public class WoodenToysFactory implements ToysFactory {
    @Override
    public Cat getCat() {
        return new WoodenCat();
    }

    @Override
    public Bear getBear() {
        return new WoodenBear();
    }

}
