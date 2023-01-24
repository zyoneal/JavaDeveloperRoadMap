package JavaCore.DesignPatterns.decorator;

import JavaCore.DesignPatterns.decorator.objects.Component;

public class ColorDecorator extends Decorator{

    public ColorDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.println("...added color");
    }

}
