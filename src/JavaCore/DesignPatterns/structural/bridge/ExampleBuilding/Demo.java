package structural.bridge.ExampleBuilding;

public class Demo {

    public static void main(String[] args) {
        IWallCreator brickWallCreator = new BrickWallCreator();
        IWallCreator concreteSlabWallCreator = new ConcreteSlabWallCreator();

        BuildingCompany buildingCompany = new BuildingCompany();
        buildingCompany.buildFoundation();

        buildingCompany.wallCreator = brickWallCreator;
        buildingCompany.buildRoom();

        buildingCompany.wallCreator = concreteSlabWallCreator;
        buildingCompany.buildRoom();
        buildingCompany.buildRoof();
    }

}
