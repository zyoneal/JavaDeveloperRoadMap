package JavaCore.DesignPatterns.behavioral.visitor.ExampleHouse;

import javax.print.attribute.standard.PrinterLocation;

public class Demo {

    public static void main(String[] args) {
        var floor1 = new Floor(1);
        floor1.addRoom(new Room(100));
        floor1.addRoom(new Room(101));
        floor1.addRoom(new Room(102 ));

        var floor2 = new Floor(2);
        floor2.addRoom(new Room(200));
        floor2.addRoom(new Room(201));
        floor2.addRoom(new Room(202));

        var myFirm = new OfficeBuilding(25, "Design Patterns Centre");
        myFirm.addFloor(floor1);
        myFirm.addFloor(floor2);

        ElectricitySystemValidator electrician = new ElectricitySystemValidator();
        myFirm.accept(electrician);

        PlumbingSystemValidator plumber = new PlumbingSystemValidator();
        myFirm.accept(plumber);
    }
}
