package JavaCore.Algorithms;

// Алгоритм Heap Sort работает по следующей схеме:
//
//Строим кучу из массива.
//Извлекаем максимальный элемент кучи и перемещаем его в конец массива.
//Повторяем шаг 2 для оставшейся части массива, пока не будут отсортированы все элементы.
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 8, 1, 6};
        heapSort(arr);
    }

    public static void heapSort(int[] arr) {
        // Строим кучу из массива
        buildHeap(arr);

        // Извлекаем максимальный элемент кучи и перемещаем его в конец массива
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Восстанавливаем свойство кучи для оставшейся части массива
            heapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr) {
        // Находим индекс последнего родительского узла
        int lastParentIndex = (arr.length - 2) / 2;

        // Проходим по всем родительским узлам в обратном порядке и восстанавливаем свойство кучи для каждого из них
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    private static void heapify(int[] arr, int heapSize, int index) {
        // Находим индексы левого и правого потомков
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        // Находим индекс максимального элемента из трёх: текущего узла, левого потомка и правого потомка
        int maxIndex = index;
        if (leftChildIndex < heapSize && arr[leftChildIndex] > arr[maxIndex]) {
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && arr[rightChildIndex] > arr[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        // Если максимальный элемент - не текущий узел, то меняем их местами и продолжаем восстанавливать свойство кучи
        if (maxIndex != index) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            heapify(arr, heapSize, maxIndex);
        }
    }

}
