package JavaCore.FunctionalInterfaces.Lambdas;

import JavaCore.FunctionalInterfaces.Lambdas.model.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// FunctionalInterface - только 1 абстрактный метод у интерфейса. Все остальные должны быть дефолтные.
// Указывает что данный интерфейс мы будем использовать в лямбда выражениях
@FunctionalInterface
// В параметре будут все наследники Number
interface ElementProcessor<T extends Number> {
    // Какая-то функция, которая принимает всех наследников Number и возвращает double
    double process(T element);
}

@FunctionalInterface
interface Operation {

    void process();

    static void measure(Operation function) {
        long start = System.currentTimeMillis();
        function.process();
        long end = System.currentTimeMillis();
        System.out.println("Time spend : " + (end - start));
    }

    // Посчитать время двух методов. Функция высшего порядка (Принимает лямбда выражение и возвращает лямбда выражение)
    default Operation combineOperation(Operation thatOperation) {
        return () -> {
            process();
            thatOperation.process();
        };
    }

}

public class LambdasExample {

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.4);
        doubleList.add(8.6);
        doubleList.add(3.23);
        doubleList.add(4.13);
        doubleList.add(12.2);

        // передаем лист интов и пишем лямбду которая будет сопоставима с методом в интерфейсе ElementProcessor.
        // пишет лямбду и указываем что это наследник Number Double.
        processElements(integerList, x -> Math.exp(x.doubleValue()));
        processElements(doubleList, x -> Math.exp(x.doubleValue()));

        // TimeUtil.measure(someLongRunningMethod())
        // Замер времени через лямбда выражение
        Operation.measure(() -> Arrays.sort(createRandomArray()));
        // Замер времени двух операций
        Operation operation1 = () -> Arrays.sort(createRandomArray());
        Operation operation2 = () -> Arrays.sort(createRandomArray());
        Operation.measure(operation1.combineOperation(operation2));

        // ============================= METHOD REFERENCE =======================================
        String s = "Hello";
        Double d = 0.123;
        // CustomClass :: staticMethod;
        // CustomClassInstance :: nonStaticMethod;
        // CustomClass :: nonStaticMethod;
        // CustomClass :: new *;

        TransformUtils<Double> doubleTransformUtils = new TransformUtils<>();
        // в параметр Math.sin(); передаем первый параметр. Math.sin(d) == Math::sin
        System.out.println("doubleTransformUtils.transform(d, Math::sin) = " + doubleTransformUtils.transform(d, Math::sin));

        TransformUtils<String> stringTransformUtils = new TransformUtils<>();
        System.out.println("stringTransformUtils.transform(s, TransformUtils::exclaim) = " + stringTransformUtils.transform(s, TransformUtils::exclaim));

        String suffix = "Victor";
        // через лямбду
        System.out.println("stringTransformUtils.transform(s, x -> x.concat(suffix)) = " + stringTransformUtils.transform(s, x -> x.concat(suffix)));
        // через methodReference
        System.out.println("stringTransformUtils.transform(suffix, s::concat) = " + stringTransformUtils.transform(suffix, s::concat));

        System.out.println("stringTransformUtils.transform(s, String::toUpperCase) = " + stringTransformUtils.transform(s, String::toUpperCase));
        System.out.println("stringTransformUtils.transform(s, String::new) = " + stringTransformUtils.transform(s, String::new));

        // ====================================== ОБЛАСТЬ ВИДИМОСТИ ЛЯМБДА ==============================
        LambdaScopeTest scopeTest = new LambdaScopeTest();
        LambdaScopeTest.LambdaScopeInner inner = scopeTest.new LambdaScopeInner();
        inner.testScope(9999.000);

        // ===================================== STATIC И DEFAULT методы в интерфейсах ==================
        // когда класс екстендится от другого класса и имплементится от интерфейса и там одинаковые методы,
        // то преимущество будет за методом который находится в классе, а не в интерфейсе
        Circle circle = new Circle();
        System.out.println(circle.calcSomething());
    }

    // первым параметром будет List который может принимать всех наследников Number, вторым параметром будет функция которая находится в интерфейсе ElementProcessor
    private static <T extends Number> void processElements(List<T> list, ElementProcessor function) {
        // создаем лист даблов, так как функция возвращает даблы
        List<Double> doubleList = new ArrayList<>();
        // проходимся по листу Integers
        for (Number i : list) {
            // выполняем действие функции из интерфейса над каждым элементом и добавляем в лист даблов
            doubleList.add(function.process(i));
        }
        // печатаем лист даблов
        System.out.println(doubleList);
    }

    private static double multiply(int x, int y) {
        return x * y / 10.0;
    }

    private static int[] createRandomArray() {
        int[] myArray = new int[1000000];
        Random random = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = random.nextInt(myArray.length);
        }
        return myArray;
    }

}
