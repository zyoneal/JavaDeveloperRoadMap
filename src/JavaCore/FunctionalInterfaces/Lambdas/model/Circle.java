package JavaCore.FunctionalInterfaces.Lambdas.model;

public class Circle implements Shape, AnotherShape {

    public Circle() {
        System.out.println("Creating circle");
    }

    @Override
    public double calcSquare() {
        return 1;
    }

    // Выбрать какой именно нужен метод из 2 интерфейсов с одинаковыми методами
    public double calcSomething() {
        return Shape.super.calcSomething();
    }

}
