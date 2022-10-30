package JavaCore.OOP.Inheritance;

// Bus - depends on Fuel -> extends FuelAuto -> FuelAuto extends Auto
public class Bus extends FuelAuto {

    private int passengersNumber;

    //add number of passengers
    public Bus(String producer, String model, Engine engine, int availablePatrol, int tankVolume, int passengersNumber) {
        super(producer, model, engine, availablePatrol, tankVolume);
        this.passengersNumber = passengersNumber;
        System.out.println("Bus is initialized");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePatrol());
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Bus is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Bus has stopped");
    }

    // overloading --------(можно вызвать только из обьекта типа BUS)
    public void fuelUp() {
        int volume = getTankVolume() - getAvailablePatrol();
        fuelUp(volume);
    }

    // overriding ---------(можно вызвать только из обьекта типа Bus И FuelAuto)
    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePatrol() + petrolVolume;
        if (volume > getTankVolume()) {
            setAvailablePatrol(getTankVolume());
        }
        System.out.println("Adding DIESEL");
    }

    public void pickUpPassengers(int passengersNumber) {
        this.passengersNumber += passengersNumber;
        System.out.println("Picking up " + passengersNumber + " passengers");
    }

    public void releasePassengers() {
        if (isRunning) {
            stop();
        }
        passengersNumber = 0;
        System.out.println("Passengers released");
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

}
