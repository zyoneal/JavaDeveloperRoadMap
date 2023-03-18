public class MergeSortedArrays {

        //============== ОБЬЕДИНИТЬ ДВА ОТСОРТИРОВАНЫХ МАССИВА В ОДИН=================
        public static int[] mergeSortedArrays(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < firstArray.length && bIndex < secondArray.length) {
            if (firstArray[aIndex] < secondArray[bIndex]) {
                result[aIndex + bIndex] = firstArray[aIndex++];

            } else {
                result[aIndex + bIndex] = secondArray[bIndex++];
            }
        }
        while (aIndex < firstArray.length) {
            result[aIndex + bIndex] = firstArray[aIndex++];
        }
        while (bIndex < secondArray.length) {
            result[aIndex + bIndex] = secondArray[bIndex++];
        }
        return result;
    }

}
