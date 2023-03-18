package JavaCore.DesignPatterns.structural.composite.ExampleShape;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Shape {

    private List<Shape> components = new ArrayList<>();

    void addComponent(Shape component) {
        components.add(component);
    }

    void removeComponent(Shape component) {
        components.remove(component);
    }

    @Override
    public void draw() {
        for (Shape component : components) {
            component.draw();
        }
    }

}
