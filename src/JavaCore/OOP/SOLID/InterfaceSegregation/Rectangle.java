package JavaCore.OOP.SOLID.InterfaceSegregation;

// NOT VALID
public class Rectangle implements Shape {

    @Override
    public void drawLine() {

    }

    @Override
    public void drawCircle() {

    }

    @Override
    public void drawRect() {
        System.out.println("draw rectangle");
    }

}
