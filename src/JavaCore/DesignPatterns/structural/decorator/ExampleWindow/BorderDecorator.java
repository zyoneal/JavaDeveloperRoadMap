package JavaCore.DesignPatterns.structural.decorator.ExampleWindow;

import JavaCore.DesignPatterns.structural.decorator.ExampleWindow.objects.Component;

public class BorderDecorator extends Decorator {

    public BorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void afterDraw() {
        System.out.println("... add border");
    }

}
