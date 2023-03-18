package structural.flyweight.ExampleMinecraft;

public class EarthBlock implements Block {

    @Override
    public void create(Property property) {
        System.out.println("Created " + property.toString());
    }

}
