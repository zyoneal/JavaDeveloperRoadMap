package structural.flyweight.ExampleMinecraft;

import java.util.ArrayList;
import java.util.List;

public class FlyweightBlocks {

    public static void main(String[] args) {
        BlockFactory blockFactory = new BlockFactory();
        List<Block> blocks = new ArrayList<>();

        blocks.add(blockFactory.getShape(Property.EARTH));
        blocks.add(blockFactory.getShape(Property.WATER));
        blocks.add(blockFactory.getShape(Property.STONE));

    }

}
