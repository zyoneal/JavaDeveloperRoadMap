package structural.bridge.ExampleBuilding;

public class BuildingCompany implements IBuildCompany {

    public  IWallCreator wallCreator;

    @Override
    public void buildFoundation() {

    }

    @Override
    public void buildRoom() {
        wallCreator.buildWall();
        wallCreator.buildWallWithDoor();
        wallCreator.buildWallWithWindow();
        wallCreator.buildRoom();
    }

    @Override
    public void buildRoof() {
        System.out.println("Build roof");
    }

    public IWallCreator getWallCreator() {
        return wallCreator;
    }

    public void setWallCreator(IWallCreator wallCreator) {
        this.wallCreator = wallCreator;
    }

}
