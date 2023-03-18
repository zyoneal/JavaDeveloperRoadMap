package JavaCore.DesignPatterns.structural.facade.ExampleSki;

public class HotelBookingSystem {

    public int bookRoom(int roomQuality) {
        switch (roomQuality) {
            case 3:
                return 250;
            case 4:
                return 500;
            case 5:
                return 900;
            default:
                throw new RuntimeException();
        }
    }
}
