package creational.builder;

public class CarBuilder {

    String m = "Default";

    Transmition t = Transmition.AUTO;

    int s = 120;

    CarBuilder buildMake(String m) {
        this.m = m;
        return this;
    }

    CarBuilder buildTransmition(Transmition t) {
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpeed(int s) {
        this.s = s;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setMake(m);
        car.setTrasmition(t);
        car.setMaxSpeed(s);
        return car;
    }

}
