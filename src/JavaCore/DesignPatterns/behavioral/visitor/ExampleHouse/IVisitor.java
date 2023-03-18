package behavioral.visitor.ExampleHouse;

public interface IVisitor {

    void visit(OfficeBuilding officeBuilding);

    void visit(Floor floor);

    void visit(Room room);

}
