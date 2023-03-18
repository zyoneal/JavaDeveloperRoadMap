import java.util.Arrays;

//Selection sort - это алгоритм сортировки, который проходит через массив несколько раз, на каждой итерации находит наименьший элемент
// и помещает его в начало неотсортированной части массива. Принцип работы алгоритма selection sort в Java может быть описан следующим образом:
//
//Находим наименьший элемент в массиве и меняем его местами с первым элементом массива.
//Находим наименьший элемент в массиве, начиная с индекса 1, и меняем его местами с элементом массива, находящимся на второй позиции.
//Продолжаем процесс, перебирая все элементы массива и находя наименьший элемент в неотсортированной части массива и меняя его местами
//с первым элементом в неотсортированной части.

//Этот процесс продолжается до тех пор, пока не будет отсортирована вся последовательность.
public class SelectionSort {

    //=========== SELECTION SORT ======================
    //СРАВНИТЬВАТЬ 1 ЭЛЕМЕНТ СО ВСЕМИ, ЕСЛИ НАХОДИШЬ МЕНЬШЕ ТО ПЕРЕСТАВЛЯЕШЬ

    public void selectionSort(int[] arr) {
        int n = arr.length;
        // Проход по неотсортированной части массива
        for (int i = 0; i < n-1; i++) {
            // Находим наименьший элемент в неотсортированной части
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Меняем местами наименьший элемент с первым элементом неотсортированной части
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
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
