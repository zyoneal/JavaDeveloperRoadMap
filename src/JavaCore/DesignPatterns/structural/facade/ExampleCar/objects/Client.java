package structural.facade.ExampleCar.objects;// Фасад предоставляет единую «точку доступа» к подсистеме, тем самым
//упрощая его использование и понимание.

// Скрыть сложную внутреннюю реализацию и предоставтиь простой интерфейс
// Упрощение взаимодействия с обьектам системы (или несколькиз систем)
// Более высокий уровень использования системы
// Можно обращаться и к самим внутренним обьектам (без фасада)

import structural.facade.ExampleCar.CarFacade;
import structural.facade.ExampleCar.parts.Door;
import structural.facade.ExampleCar.parts.Wheel;
import structural.facade.ExampleCar.parts.Zazhiganie;

public class Client {

    private static Zazhiganie zazhiganie;

    public static void main(String[] args) {
        // вызов без фасада
        Door door = new Door();
        door.open();

        zazhiganie = new Zazhiganie();
        zazhiganie.fire();

        Wheel wheel = new Wheel();
        wheel.turn();

        // Вызов с фасадом
        CarFacade carFacade = new CarFacade();
        carFacade.go();
    }

}
