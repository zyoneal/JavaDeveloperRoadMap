package structural.facade.ExampleSki;

public class SkiResortFacade {

    private SkiRent skiRent = new SkiRent();

    private SkiResortTicketSystem skiResortTicketSystem = new SkiResortTicketSystem();

    private HotelBookingSystem hotelBookingSystem = new HotelBookingSystem();

    public int haveGoodRest(int height, int weight, int feetSize, int skierLevel, int roomQuality) {
        int skiPrice = skiRent.RentSki(weight, skierLevel);
        int skiBootsPrice = skiRent.rentBoots(feetSize, skierLevel);
        int polePrice = skiRent.RentPole(height);
        int oneDayTicketPrice = skiResortTicketSystem.buyOneDayTicket();
        int hotelPrice = hotelBookingSystem.bookRoom(roomQuality);
        return skiPrice + skiBootsPrice + polePrice + oneDayTicketPrice + hotelPrice;
    }

    public int haveRestWithOwnSkis() {
        int oneDayTicketPrice = skiResortTicketSystem.buyOneDayTicket();
        return oneDayTicketPrice;
    }

}
