package JavaCore.DesignPatterns.structural.decorator.ExampleWindow.objects;

public class TextView implements Component{

    @Override
    public void draw() {
        System.out.println("draw textview");
    }

}
