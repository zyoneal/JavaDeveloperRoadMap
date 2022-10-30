package JavaCore.Algorithms;

import java.util.Arrays;

public class InsertSort {

//================================= INSERT SORT=============================
//ВСТАВЛЯЕМ НОВЫЕ ЭЛЕМЕНТЫ В ОТСОРТИРОВАНУЮ ЧАСТЬ

    public static void insertSort(int[] array) {
        for (int barrier = 1; barrier < array.length; barrier++) {
            int newElement   = array[barrier];
            int location = barrier;
            while (location > 0 && array[location - 1] > newElement) {
                array[location]  = array[location - 1];
                location--;
            }
            array[location] = newElement;
        }
        System.out.println(Arrays.toString(array));
    }

}
