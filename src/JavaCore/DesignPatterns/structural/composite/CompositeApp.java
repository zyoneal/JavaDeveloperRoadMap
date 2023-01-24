package JavaCore.DesignPatterns.composite;

// Компоновщик позволяет нам сохранять древовидную структуру и
//работать одинаково с родителями и детьми в дереве.

// Сумки - сумка в сумке.
public class CompositeApp {

    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape square3 = new Square();

        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Composite composite = new Composite();

        Composite composite1 = new Composite();
        Composite composite2 = new Composite();
        Composite composite3 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(circle1);

        composite2.addComponent(square3);
        composite2.addComponent(circle2);

        composite3.addComponent(circle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(composite3);
        composite.draw();

    }

}
