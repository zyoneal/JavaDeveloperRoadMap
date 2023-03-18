package structural.bridge.ExampleBuilding;

public class ConcreteSlabWallCreator implements IWallCreator {

    @Override
    public void buildWallWithDoor() {
        System.out.println("Concrete");
    }

    @Override
    public void buildWall() {
        System.out.println("Concrete");
    }

    @Override
    public void buildWallWithWindow() {
        System.out.println("Concrete");
    }

    @Override
    public void buildRoom() {
        System.out.println("Concrete");
    }

}
