package JavaCore.DesignPatterns.behavioral.visitor.ExampleHouse;

public class ElectricitySystemValidator implements IVisitor {
    @Override
    public void visit(OfficeBuilding officeBuilding) {
        String electricityState = officeBuilding.electricitySystemId > 1000 ? "good" : "bad";
        System.out.println(officeBuilding.buildingName + " " + electricityState);
    }

    @Override
    public void visit(Floor floor) {
        System.out.println("Floor number: " + floor.floorNumber);
    }

    @Override
    public void visit(Room room) {
        System.out.println("Room number: " + room.roomNumber);
    }

}
