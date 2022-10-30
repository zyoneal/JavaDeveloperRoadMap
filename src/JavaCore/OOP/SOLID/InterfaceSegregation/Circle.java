package JavaCore.OOP.SOLID.InterfaceSegregation;

// NOT VALID
public class Circle implements Shape {

    @Override
    public void drawLine() {

    }

    @Override
    public void drawCircle() {
        System.out.println("draw circle");
    }

    @Override
    public void drawRect() {

    }

}
