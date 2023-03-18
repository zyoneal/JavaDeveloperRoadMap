package structural.flyweight.ExampleMinecraft;

public class StoneBlock implements Block {

    @Override
    public void create(Property property) {
        System.out.println("Created " + property.toString());
    }

}
