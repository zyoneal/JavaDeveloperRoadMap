package behavioral.visitor.ExampleHouse;

import java.util.List;

public class OfficeBuilding implements IElement{

    int electricitySystemId;

    String buildingName;

    private List<Floor> floors;

    public OfficeBuilding(int electricitySystemId, String buildingName) {
        this.electricitySystemId = electricitySystemId;
        this.buildingName = buildingName;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        for (var floor:floors) {
            floor.accept(visitor);
        }
    }

}
