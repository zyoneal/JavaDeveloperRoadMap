package JavaCore.Collections.SetAndMap.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetRunner {

    public static void main(String[] args) {
        // =========== HashSet, TreeSet, LinkedHashSet =============================
        String[] cars = {"Mini", "Mercedes-Benz", "Audi", "VW", "Smart", "Toyota", "Porsche"};
        String[] otherCars = {"Audi", "Ford", "GMC", "Toyota", "Chevrolet"};

        // HashSet - не сохраняет порядок уникальных элементов
        // LinkedHashSet - сохраняет порядок уникальных элементов
        // TreeSet - естественный порядок (Сортировка)

        // HashSet - наиболее быстрый, наиболее эффективный

        Set<String> carSet = new LinkedHashSet<>(Arrays.asList(cars));
        Set<String> otherCarSet = new LinkedHashSet<>(Arrays.asList(otherCars));

        Set<String> uniqueCars = new LinkedHashSet<>(carSet);
        uniqueCars.addAll(otherCarSet);

        // print(uniqueCars);

        // =========== HashSet + equals ============================================
        Set<Car> sixCars = new HashSet<>();
        sixCars.add(new Car("VW", "Golf", 45));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VW", "Polo", 35));
        sixCars.add(new Car("BMW", "Z4", 120));
        sixCars.add(new Car("BMW", "4401", 200));

        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota", "Auris", 40));
        europaCars.add(new Car("Reno", "Clio", 30));
        europaCars.add(new Car("Reno", "Megan", 50));
        europaCars.add(new Car("VW", "Golf", 45));
        europaCars.add(new Car("VW", "Polo", 35));

        NavigableSet<Car> uniqueCarsManufacturer = new TreeSet<>(sixCars);
        uniqueCarsManufacturer.addAll(europaCars);
        print(uniqueCarsManufacturer);

        // Следующий элемент за переданым в параметр
        System.out.println("Higher");
        System.out.println(uniqueCarsManufacturer.higher(new Car("Toyota", "Auris", 40)));
        // Предыдущий элемент за переданым в параметр
        System.out.println("Lower");
        System.out.println(uniqueCarsManufacturer.lower(new Car("Toyota", "Auris", 40)));
        // Вывод ближнего элемента который больше чем тот который передали в параметр из метода compareTO
        System.out.println("Ceiling");
        System.out.println(uniqueCarsManufacturer.ceiling(new Car("Toyota", "Auris", 40)));
        // Вывод ближнего элемента который меньше чем тот который передали в параметр из метода compareTO
        System.out.println("Floor");
        System.out.println(uniqueCarsManufacturer.floor(new Car("Toyota", "Auris", 40)));

        // вывод от рута до переданого элемента не включая
        SortedSet<Car> cars1 = uniqueCarsManufacturer.headSet(new Car("Toyota", "Auris", 40));
        // print(cars1);
        // вывод с конца до переданого элемента включая
        SortedSet<Car> cars2 = uniqueCarsManufacturer.tailSet(new Car("Toyota", "Auris", 40));
        // print(cars2);

        // вывод подсета (первый параметр включая , второй не включая)
        SortedSet<Car> cars3 = uniqueCarsManufacturer.subSet(new Car("Toyota", "Auris", 40), new Car("Audi", "A3", 60));
        // print(cars3);
        // вывод включая 2 параметра
        SortedSet<Car> cars4 = uniqueCarsManufacturer.subSet(new Car("Toyota", "Auris", 40), true, new Car("Audi", "A3", 60), true);
        // print(cars4);


        //=================== РАБОТА С МНОЖЕСТВАМИ ============================
        //=================== обьединение
        uniqueCarsManufacturer.addAll(europaCars);

        //=================== разность
        sixCars.removeAll(europaCars);
        // print(sixCars);

        europaCars.removeAll(sixCars);
        // print(europaCars);

        //================== пересечение
        sixCars.retainAll(europaCars);

        //================== симетрическая разность
        // Сперва сделать обьединение, потом пересечение и из обьединения удалить пересечение
        uniqueCars.removeAll(sixCars);

        //================== КАК РАБОТАЕТ ХЕШ СЕТ =============================================
        // HashSet(initialCapacity, loadFactor) - в основании у HashSet лежит HashMap,
        // которая позволяет разширять HashSet и хранить обьекты в хешмапе.
        // В хешмапе берется максимальное значение либо 16 либо (размер коллекции / лоад фактор + 1)
        // По дефолту у хешсета initialCapacity = 16
        // если у хешсета меньше 13 элементов (1 - 12), то хешсет не разширяется, но если 13 и больше ,
        // то происходит разширение хешсета --> потому что 13 / 0.75 = 17.3 > 16.
        // Нельзя использовать большой loadFactor. Снижается производительность.

    }

    private static void print(Set<Car> cars) {
        System.out.printf("%-20s %-20s %-20s \n", "Car Brand", "Model", "Price per day");
        for (Car car : cars) {
            System.out.printf("%-20s %-20s %-20s \n",
                    car.getCarBrand(),
                    car.getModel(),
                    car.getPricePerDay());
        }
    }

}
