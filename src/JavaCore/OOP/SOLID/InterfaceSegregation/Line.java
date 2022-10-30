package JavaCore.OOP.SOLID.InterfaceSegregation;

// NOT VALID
public class Line implements Shape {

    @Override
    public void drawLine() {
        System.out.println("draw line");
    }

    @Override
    public void drawCircle() {

    }

    @Override
    public void drawRect() {

    }

}
