package Inheritance;

public class InheritanceMain {

    public static void main(String[] args) {
        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 900);
        Engine busEngine = new Engine(3.5, EngineType.DIESEL, 500);

        //Autos with engine
        Auto truck = new Truck("Volvo", "VNL 300 ", truckEngine, 300, 500, 1000);
        Auto bus = new Bus("Mercedes", "Sprinter", busEngine, 30, 75, 12);
        // Electric car don't need engine
        Auto electricCar = new ElectricCar("Tesla", "Model S", 100500, 4);

        polymorphism(bus);
        polymorphism(truck);
        polymorphism(electricCar);
    }

    // каждый обьект который является ребенком Auto вызовет свои переопределенные методы
    private static void polymorphism(Auto auto) {
        auto.start();
        auto.stop();
        auto.energize();
    }

}
