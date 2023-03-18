package JavaCore.DesignPatterns.structural.decorator.ExampleWindow;

import JavaCore.DesignPatterns.structural.decorator.ExampleWindow.objects.Component;

public class ColorDecorator extends Decorator{

    public ColorDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.println("...added color");
    }

}
