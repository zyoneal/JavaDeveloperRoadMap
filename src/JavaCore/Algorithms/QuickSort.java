//Алгоритм Quick Sort работает по следующей схеме:
//
//Выбираем опорный элемент из массива.
//Разделяем массив на две части: элементы, меньшие опорного, и элементы, большие опорного.
//Рекурсивно повторяем шаги 1 и 2 для каждой части массива, пока все элементы не будут отсортированы.

// (n log n)
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1000, 5, 7, 3, 2, 500, 13, 19, -5};
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        // Проверяем, что левая граница не больше правой, в таком случае выходим из метода
        if (left >= right) {
            return;
        }

        // Выбираем опорный элемент - это может быть любой элемент из подмассива
        int pivot = arr[(left + right) / 2];

        // Разделяем массив на две части: элементы, меньшие опорного, и элементы, большие опорного
        int index = partition(arr, left, right, pivot);

        // Рекурсивно сортируем левую и правую части массива
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {
        // Двигаем указатель с левой границы к правой, пока не найдём элемент, больший опорного
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            // Двигаем указатель с правой границы к левой, пока не найдём элемент, меньший опорного
            while (arr[right] > pivot) {
                right--;
            }

            // Если указатели не пересеклись, меняем местами элементы, стоящие на левом и правом указателях
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        // Возвращаем индекс элемента, следующего за последним элементом, меньшим опорного
        return left;
    }

}
