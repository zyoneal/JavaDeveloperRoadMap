public class Inversion {

    //================Inversion left to mid================
    public static void inversionLeftToMid(int[] data) {
        for (int i = 0; i < data.length / 2; i++) {
            int temp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = temp;
        }
    }

    //================Inversion mid to left================
    private static void inversionMidToLeft(int[] data) {
        for (int index = data.length / 2; index >= 0; index--) {
            swap(data, index, data.length - 1 - index);
        }

    }

    // ===================swap elements===============
    private static void swap(int[] data, int firstElement, int secondElement) {
        int temp = data[firstElement];
        data[firstElement] = data[secondElement];
        data[secondElement] = temp;
    }

}
