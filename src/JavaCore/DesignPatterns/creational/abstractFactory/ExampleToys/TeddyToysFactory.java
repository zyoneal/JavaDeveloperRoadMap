package JavaCore.DesignPatterns.creational.abstractFactory.ExampleToys;

public class TeddyToysFactory implements ToysFactory {
    @Override
    public Cat getCat() {
        return new TeddyCat();
    }

    @Override
    public Bear getBear() {
        return new TeddyBear();
    }

}
