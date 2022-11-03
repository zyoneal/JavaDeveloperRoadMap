package JavaCore.OOP.Inheritance;

import java.util.ArrayList;
import java.util.List;

public class Engine {

    private double volume;

    private EngineType engineType;

    private int power;

    private List<Piston> pistons = new ArrayList<>();

    public Engine() {
    }
    public Engine(double volume, EngineType engineType, int power) {
        this.volume = volume;
        this.engineType = engineType;
        this.power = power;
        for (int i = 1; i <= 5; i++) {
            this.pistons.add(new Piston(0.3, i));
        }
        System.out.println("Engine initialized");
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public List<Piston> getPistons() {
        return pistons;
    }

    public void setPistons(List<Piston> pistons) {
        this.pistons = pistons;
    }

}

