package JavaCore.Algorithms;

import java.util.Arrays;

public class BubbleSort {

    //Обычная сортировка пузырьком
    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    //ВСЕ ЗНАЧЕНИЯ БОЛЬШЕ ВПРАВО
    //правая граница сдвигается влево, цикл пробегает до границы меняя элементы
    public static void bubbleSortRight(int[] data) {
        for (int barrier = data.length - 1; barrier >= 1; barrier--) {
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }
    }

    //ВСЕ ЗНАЧЕНИЯ МЕНЬШЕ ВЛЕВО
        private static void bubbleSortLeft(int [] data) {
        for (int barrier = 0; barrier < data.length - 1; barrier++) {
            for (int index = data.length - 1; index > barrier; index--) {
                if (data[index] < data[index - 1]) {
                    swap(data, index);
                }
                System.out.print(index);
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(data));
    }

    private static void swap(int[] data, int j) {
        int temp = data[j];
        data[j] = data[j - 1];
        data[j - 1] = temp;
    }

}
