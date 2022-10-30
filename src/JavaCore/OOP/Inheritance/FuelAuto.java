package JavaCore.OOP.Inheritance;

// Abstract class for Autos with fuel -> extends Auto + set patrol, tankVolume
public abstract class FuelAuto extends Auto {

    private int availablePatrol; // заполнено

    private int tankVolume;  // обьем бака

    public FuelAuto(String producer, String model, Engine engine, int availablePatrol, int tankVolume) {
        super(producer, model, engine);
        this.availablePatrol = availablePatrol;
        this.tankVolume = tankVolume;
        System.out.println("Fuel Auto initialized");
    }

    public void fuelUp(int petrolVolume) {
        availablePatrol += petrolVolume;
        System.out.println("Adding fuel");
    }

    public int getAvailablePatrol() {
        return availablePatrol;
    }

    public void setAvailablePatrol(int availablePatrol) {
        this.availablePatrol = availablePatrol;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

}
