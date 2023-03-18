package behavioral.visitor.ExampleHouse;

import java.util.ArrayList;
import java.util.List;

public class Floor implements IElement{

    int floorNumber;

    private List<Room> rooms = new ArrayList<>();

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        for (var room:rooms) {
            room.accept(visitor);
        }
    }

}
