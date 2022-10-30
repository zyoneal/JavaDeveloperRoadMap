package JavaCore.OOP.SOLID.InterfaceSegregation;

// NOT VALID -> не нужно так создавать интерфейсы.
// Лучше создать много разных узкоспециализированных интерфейсов. {ILine, ICircle, IRect}
public interface Shape {

    void drawLine();

    void drawCircle();

    void drawRect();

}
