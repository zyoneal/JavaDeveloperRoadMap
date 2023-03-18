package JavaCore.DesignPatterns.creational.factoryMethod.ExampleCar;

// известен интерфейс, но заранее неизвестно какая из реализаций будет использоваться
// получение ссылки на обьект в зависимости от входящих условий

public class Program {

    public static void main(String[] args) {
      CarSelector carSelector = new CarSelector();

      Car car = carSelector.getCar(RoadType.CITY);
      car.drive();
      car.stop();

      car = carSelector.getCar(RoadType.OFF_ROAD);
      car.drive();
      car.stop();
    }

}
