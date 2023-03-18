package Inheritance;
public class ElectricCar extends Auto {

    private int batteryValue;

    private int passengersNumber;

    // Electric car don't need engine
    public ElectricCar(String producer, String model, int batteryValue, int passengersNumber) {
        // Electric car don't need engine
        super(producer, model, new Engine());
        // But Electric car needs battery etc.
        this.batteryValue = batteryValue;
        this.passengersNumber = passengersNumber;
        System.out.println("Electric car is initialized");
    }

    @Override
    public void energize() {
        charge();
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Car is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Car has stopped");
    }

    public int getBatteryValue() {
        return batteryValue;
    }

    public void setBatteryValue(int batteryValue) {
        this.batteryValue = batteryValue;
    }

    public int getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    private void charge() {
        System.out.println("Buttery is charging");
    }

}
