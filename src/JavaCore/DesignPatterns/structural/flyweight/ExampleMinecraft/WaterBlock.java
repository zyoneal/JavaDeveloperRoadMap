package structural.flyweight.ExampleMinecraft;

public class WaterBlock implements Block {

    @Override
    public void create(Property property) {
        System.out.println("Created " + property.toString());
    }

}
