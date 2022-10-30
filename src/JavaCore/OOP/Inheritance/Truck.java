package JavaCore.OOP.Inheritance;

public class Truck extends FuelAuto {

    private int cargoWeight;

    public Truck(String producer, String model, Engine engine, int availablePatrol, int tankVolume, int cargoWeight) {
        super(producer, model, engine, availablePatrol, tankVolume);
        this.cargoWeight = cargoWeight;
        System.out.println("Truck is initialized");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePatrol());
    }

    // overloading
    public void fuelUp() {
        int volume = getTankVolume() - getAvailablePatrol();
        fuelUp(volume);
    }

    // overriding
    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePatrol() + petrolVolume;
        if (volume > getTankVolume()) {
            setAvailablePatrol(getTankVolume());
        }
        System.out.println("Adding DIESEL");
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Truck is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Truck has stopped");
    }

    public void load() {
        System.out.println("Cargo loaded");
    }

    public void unload() {
        System.out.println("Cargo unloaded");
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

}
