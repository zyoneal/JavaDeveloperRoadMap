package Lambdas;

import Lambdas.model.Person;
import Lambdas.model.RichPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import Lambdas.model.Circle;
import Lambdas.model.Rectangle;
import Lambdas.model.Square;

public class LambdaFunctionExample {

    public static void main(String[] args) {
        List<RichPerson> employees = new ArrayList<>();
        employees.add(new RichPerson("Alex", "Black", 50000));
        employees.add(new RichPerson("John", "Green", 75000));
        employees.add(new RichPerson("Sam", "Brown", 80000));
        employees.add(new RichPerson("Tony", "Grey", 90000));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alex", "Smith", 25));
        people.add(new Person("John", "Green", 30));
        people.add(new Person("Sam", "Brown", 32));
        people.add(new Person("Tony", "Grey", 34));

        // Работа с готовым интерфесом Predicate (по критерию сравнить элементы в коллекции и сделать действие)
        findMatch(employees, e -> e.getSalary() > 60000);
        findMatch(people, e -> e.getAge() > 30);

        // Работа с готовым интерфейсом Function (Пройтись по коллекции, сделать действие над одним типом, а вернуть другой тип)
        // Function использовать когда в стримах используешь map(). Применять функцию к каждому жлементу и трансформировать коллекцию
        System.out.println("Total salary " + calcSum(employees, RichPerson::getSalary));
        System.out.println("Total age " + calcSum(people, Person::getAge));

        // BiFunction apply(). Принимает 2 разных типа и возвращает третий тип.

        // BinaryOperator. Принимает 3 одинаковых типа и возвращает его же. Пригодится в стримах в методе reduce()
        // Когда есть много обьектов 1 типа и найти самого старшего и тд.
        // можно подставить любую функцию
        BinaryOperator<Integer> combiner = (n1, n2) -> n1 + n2;
        Integer zeroElement = 0;
        System.out.println("Combined salary" + combine(employees, zeroElement, RichPerson::getSalary, combiner));

        // Consumer (Когда хотим выполнить метод foreach() у нашей коллекции)
        // повышение зарплат на 10%
        employees.forEach(e -> e.setSalary(e.getSalary() * 11 / 10));
        employees.forEach(System.out::println);

        // работа с готовым интерфейсом Supplier (Добавить конструкторы в массив и от туда их вызывать)
        Supplier[] shapes = {Circle::new, Rectangle::new, Square::new};
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(3);
            Supplier supplier = shapes[index];
            supplier.get();
        }
    }

    private static <T> void findMatch(List<T> elements, Predicate<T> predicateFunction) {
        for (T e : elements) {
            if (predicateFunction.test(e)) {
                System.out.println(e);
            }
        }
    }

    // apply() - принимает любой тип и возвращает другой. Тут принимает любой , возвращает int
    private static <T> int calcSum(List<T> elements, Function<T, Integer> function) {
        int sum = 0;
        for (T el : elements) {
            sum += function.apply(el);
        }
        return sum;
    }

    // T - input param
    // R - result
    // Выбор операции дает преимущество
    private static <T, R> R combine(List<T> elements, R zeroElement, Function<T, R> function, BinaryOperator<R> combiner) {
        for (T el : elements) {
            zeroElement = combiner.apply(zeroElement, function.apply(el));
        }
        return zeroElement;
    }

}
