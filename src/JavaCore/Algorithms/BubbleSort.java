import java.util.Arrays;

//Сортировка пузырьком (bubble sort) - это простой алгоритм сортировки, который сравнивает каждую пару соседних элементов в массиве и меняет их местами,
// если они расположены в неправильном порядке. Алгоритм продолжает проходить по массиву,
// меняя местами соседние элементы до тех пор, пока весь массив не будет упорядочен.

//Принцип работы сортировки пузырьком в Java:
//
//Проходим по всему массиву, начиная с первого элемента и заканчивая предпоследним элементом.
//
//Сравниваем текущий элемент с его соседом справа. Если текущий элемент больше соседа, меняем их местами.
//
//После первого прохода в конце массива окажется наибольший элемент.
//
//Продолжаем проходить по массиву, начиная с первого элемента и заканчивая предпоследним элементом, сравниваем текущий элемент с его соседом справа.
// Если текущий элемент больше соседа, меняем их местами.
//
//После второго прохода в конце массива окажется второй по величине элемент.
//
//Продолжаем проходить по массиву, выполняя шаги 2-5 до тех пор, пока весь массив не будет отсортирован.
//
//Когда мы проходим по массиву и не меняем ни одного элемента местами, массив считается отсортированным.

//Имеет квадратичную сложность N^2.

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
