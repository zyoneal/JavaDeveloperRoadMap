package Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsMain {
    // E - element (для коллекций)
    // N - number ()
    // T - type ()
    // V - value ()
    // K - key ()
    // S,U,V etc.
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 0, 8, 5, 6};
        Double[] doubleArray = {0.234, 6.45, 9.034, 1.35, 4.675};
        String[] stringArray = {"abc", "vfr", "rtw", "ert"};
        printArray(intArray);
        printArray(doubleArray);
        printArray(stringArray);

        System.out.println("max for array of Integers : " + findMax(intArray));
        System.out.println("max for array of Doubles : " + findMax(doubleArray));
      //  System.out.println("max for array of Strings : " + findMax(stringArray));

        // Лист из Integer не является подтипом листа из Number. Параметры должны быть одинаковы.
        List<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        printElements(list);
        // Преобразование массива в лист. компилятор сам понимает какой именно параметр в лист передать.
        printElements(Arrays.asList(intArray));

        MyBox<Integer> myBox = new MyBox<>("");

        Double aDouble = MyBox.returnValue(0.03);

        // wildcarding
        List<Integer> integers = Arrays.asList(intArray);
        printElements(integers);

    }

    private static <T> void printArray(T[] array) {
        System.out.println("Generic method called");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    // можно экстендить класс и интерфейсы. Класс должен стоять всегда спереди
    private static <T extends Number & Comparable> T findMax(T [] array){
        T max = array[0];
        for(T element : array) {
           if( element.compareTo(max) > 0) {
               max = element;
           }
        }
        return max;
    }

    private static void printElements (List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

}
