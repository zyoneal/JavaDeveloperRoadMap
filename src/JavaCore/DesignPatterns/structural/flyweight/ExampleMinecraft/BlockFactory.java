package structural.flyweight.ExampleMinecraft;

import java.util.HashMap;
import java.util.Map;

public class BlockFactory {

    public static final Map<Property, Block> blocks = new HashMap<>();


    public Block getShape(Property property) {
        Block shape = blocks.get(property);
        if (property == null) {
            switch (property) {
                case WATER:
                    shape = new WaterBlock();
                    break;
                case EARTH:
                    shape = new EarthBlock();
                    break;
                case STONE:
                    shape = new StoneBlock();
                    break;
            }
            blocks.put(property, shape);
        }
        return shape;
    }

}
