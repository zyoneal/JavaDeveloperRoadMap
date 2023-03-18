package behavioral.visitor.ExampleHouse;

public class Room implements IElement {

    int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

}
