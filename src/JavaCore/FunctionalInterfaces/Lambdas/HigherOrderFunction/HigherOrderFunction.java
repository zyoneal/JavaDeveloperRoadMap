package Lambdas.HigherOrderFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunction {

    public static void main(String[] args) {
        List<RichPerson> persons = new ArrayList<>();
        persons.add(new RichPerson("Alex", "Black", 50000, 25));
        persons.add(new RichPerson("John", "Green", 75000, 35));
        persons.add(new RichPerson("Sam", "Brown", 80000, 40));
        persons.add(new RichPerson("Tony", "Grey", 90000, 50));
        // test predicate
        testPredicate(persons);
        // test function
        testFunction(persons);
        // test consumer
        testConsumer(persons);
    }

    // ======================================= CONSUMER ========================================
    private static void testConsumer(List<RichPerson> persons) {
        System.out.println("Testing consumer");
        // к одному параметру применяем функцию 1, а потом к тому же параметру применяем функцию 2.
        // f1.andThen(f2(x)) ==> f1(x) andThen f2(x);
        Consumer<RichPerson> rise = x -> x.setSalary(x.getSalary() * 11 / 10);
        processList(persons, rise.andThen(System.out::println));
    }

    private static <T> void processList(List<T> elements, Consumer<T> consumer) {
        for (T e : elements) {
            consumer.accept(e);
        }
    }

    // ======================================= FUNCTION ======================================

    private static void testFunction(List<RichPerson> persons) {
        System.out.println("testing function...");
        // сперва функция f2, потом основываясь на ее результатах f1
        // f1.compose(f2) ==> f1(f2(x));
        // сперва функция f1, потом основываясь на ее результатах f2
        // f1.andThen(f2) ==> f2(f1(x));
        // Возвращает функцию, которая не изменяет свой входной параметр
        // Function.identify();

        Function<RichPerson, String> name = x -> x.getFirstName() + " " + x.getLastName();
        Function<String, String> sayHello = y -> "Hello " + y;
        Function<RichPerson, String> composedFunction = sayHello.compose(name);
        transform(persons, composedFunction).forEach(System.out::println);

        List<String> transformedList = transform(persons, composedFunction);
        Function<String, String> exclaim = x -> x + "!!!";
        Function<String, String> toUpper = String::toUpperCase;

        transform(transformedList, compose(toUpper, exclaim)).forEach(System.out::println);

    }

    // комбинация неограниченого количества функций
    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        // получение начального значение
        Function<T, T> result = Function.identity();
        for (Function<T, T> f : functions) {
            result = result.andThen(f);
        }
        return result;
    }

    private static <T, R> List<R> transform(List<T> elements, Function<T, R> function) {
        List<R> list = new ArrayList<>();
        for (T elem : elements) {
            list.add(function.apply(elem));
        }
        return list;
    }

    // ================================ PREDICATE ==========================================
    private static void testPredicate(List<RichPerson> peoples) {
        System.out.println("Testing predicate...");
        // условия
        Predicate<RichPerson> isRich = x -> x.getSalary() >= 75000;
        Predicate<RichPerson> isYoung = x -> x.getAge() <= 40;
        System.out.println("Is reach and is young");
        // обьединяем условия
        findAll(peoples, isRich.and(isYoung)).forEach(System.out::println);
        System.out.println("Is reach or is young");
        // обьединяем условия
        findAll(peoples, isRich.or(isYoung)).forEach(System.out::println);
        System.out.println("Not young");
        findAll(peoples, isYoung.negate()).forEach(System.out::println);
    }

    private static <T> List<T> findAll(List<T> elements, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : elements) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

}
