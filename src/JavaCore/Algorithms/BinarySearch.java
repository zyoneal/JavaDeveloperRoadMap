package JavaCore.Algorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] testArray = {1, 3, 5, 7, 9};

        binarySearch(testArray, 3);
    }

    public static int binarySearch(int[] array, int key) {

        int low = 0;
        int high = array.length - 1;


        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == key) {
                return mid;
            }
            if (key < array[mid]) {
                high = mid - 1;
            }
            if (key > array[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

}
