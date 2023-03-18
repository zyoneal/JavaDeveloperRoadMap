package structural.bridge.ExampleBuilding;

public class BrickWallCreator implements IWallCreator{

    @Override
    public void buildWallWithDoor() {
        System.out.println("Brick");

    }

    @Override
    public void buildWall() {
        System.out.println("Brick");
    }

    @Override
    public void buildWallWithWindow() {
        System.out.println("Brick");
    }

    @Override
    public void buildRoom() {
        System.out.println("Brick");
    }

}
