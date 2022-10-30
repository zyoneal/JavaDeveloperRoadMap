package JavaCore.Algorithms;

import java.util.Arrays;

public class SelectionSort {

    //=========== SELECTION SORT ======================
    //СРАВНИТЬВАТЬ 1 ЭЛЕМЕНТ СО ВСЕМИ, ЕСЛИ НАХОДИШЬ МЕНЬШЕ ТО ПЕРЕСТАВЛЯЕШЬ

    public static void selectionSort(int[] array) {
        for (int barrier = 0; barrier < array.length - 1; barrier++) {
            int element = array[barrier];
            for (int index = barrier + 1; index < array.length; index++) {
                if (element > array[index]) {
                    int temp = array[index];
                    array[index] = array[barrier];
                    array[barrier] = temp;
                    element = array[barrier];
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //=========== СОРТИРОВКА ВЫБОРОМ ЧЕРЕЗ ПОИСК МИНИМАЛЬНОГО ЗНАЧЕНИЯ=============
    public static void selectionSortIndexMinElement(int[] array) {
        for (int step = 0; step < array.length; step++) {
            int index = min(array, step);
            int temp = array[step];
            array[step] = array[index];
            array[index] = temp;
        }
    }

    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
