package SetAndMap.Set;

public class Car implements Comparable<Car> {

    private final String carBrand;

    private final String model;

    private final Integer pricePerDay;

    public Car(String carBrand, String model, int pricePerDay) {
        this.carBrand = carBrand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    // проверка на равенство
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // приводим object в Car
        Car car = (Car) obj;
        if (!this.carBrand.equals(car.getCarBrand())) {
            return false;
        }
        if (!this.model.equals(car.getModel())) {
            return false;
        }
        // у примитивов ==, если не хочешь == , можно сделать примитив в обьект (боксинг)
        if (!this.pricePerDay.equals(car.pricePerDay)) {
            return false;
        }
        return true;
    }

    // equals не может работать без хешкода
    // x.equals(x) - true  - reflexive
    // x.equals(y) = true                 y.equals(x) = true
    // (a = b) and (b = c) --> a = c
    // Поля должны быть final , что бы не менялся хешкод. всегда есть вероятность коллизий (Генерация одинаковых хешкодов у двух разных и изменится хешкод - нельзя будет найти обьект.
    // Если x.equals(y) = true   , то их хещкоды тоже должны быть одинаковы ,
    // но если хешкоды 2 обьектов одинаковы - это не значит что эти обьекты равны,
    // всегобьектов).

    @Override
    public int hashCode() {
        int result = carBrand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + pricePerDay.hashCode();
        return result;
    }

    @Override
    public int compareTo(Car car) {
        if (pricePerDay < car.getPricePerDay()) return -1;
        if (pricePerDay > car.getPricePerDay()) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return carBrand + " " + model + " " + pricePerDay;
    }

}
