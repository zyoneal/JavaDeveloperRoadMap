package JavaCore.DesignPatterns.creational.factoryMethod.ExampleCar;

// Фабрика по созданию автомобилей
public class CarSelector {

    //Фабричный метод, который создает нужный автомобиль
    public Car getCar(RoadType roadType) {
        Car car = null;

        switch (roadType) {
            case CITY:
                car = new Porsche();
                break;
            case OFF_ROAD:
                car = new Geep();
            case GAZON:
                car = new NewGeep();
                break;
        }
        return car;
    }

}
