package creational.builder;

public class Car {

    String make;

    Transmition trasmition;

    int maxSpeed;


    public void setMake(String make) {
        this.make = make;
    }

    public void setTrasmition(Transmition trasmition) {
        this.trasmition = trasmition;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", trasmition=" + trasmition +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

}
